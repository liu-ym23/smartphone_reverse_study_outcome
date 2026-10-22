package com.larksuite.component.card.component.video.service;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.LruCache;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.media.v1.DownloadFileScene;
import com.bytedance.lark.pb.media.v1.GetFileStateByUrlRequest;
import com.bytedance.lark.pb.media.v1.GetFileStateResponse;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.data.media.VideoInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.photo.preview.utils.DownloadCheckUtil;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.f;
import com.ss.android.lark.widget.photopicker.gallery.callback.OnImageSelectListener;
import com.ss.android.lark.widget.photopicker.gallery.callback.VideoOperateListener;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes24.dex */
public final class CardVideoServiceImpl implements com.larksuite.component.card.component.video.service.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static WeakReference<CardVideoServiceImpl> f283697c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f283698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f283699b;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0006\u0010\u000b\u001a\u00020\u0007J\u0016\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007¨\u0006\u0010"}, d2 = {"Lcom/larksuite/component/card/component/video/service/CardVideoServiceImpl$CardPreviewFinishedListener;", "Lcom/ss/android/lark/widget/photopicker/gallery/callback/OnImageSelectListener;", "<init>", "()V", "selectPosition", "", "position", "", "previousKey", "", "exitListener", "describeContents", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CardPreviewFinishedListener implements OnImageSelectListener {
        public static final Parcelable.Creator<CardPreviewFinishedListener> CREATOR = null;

        public static final class a implements Parcelable.Creator<CardPreviewFinishedListener> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final CardPreviewFinishedListener createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "parcel");
                r100.readInt();
                return new CardPreviewFinishedListener();
            }

            @Override // android.os.Parcelable.Creator
            public final CardPreviewFinishedListener[] newArray(int r100) {
                return new CardPreviewFinishedListener[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        public CardPreviewFinishedListener() {
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.ss.android.lark.widget.photopicker.gallery.callback.OnImageSelectListener
        public void selectPosition(int r100, String r101) {
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "dest");
            r100.writeInt(1);
        }

        @Override // com.ss.android.lark.widget.photopicker.gallery.callback.OnImageSelectListener
        public void exitListener(String r100) {
            Log.i("CardVideoService", "preview video exited");
            WeakReference<CardVideoServiceImpl> r101 = CardVideoServiceImpl.f283697c;
            CardVideoServiceImpl.f283697c = null;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J4\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larksuite/component/card/component/video/service/CardVideoServiceImpl$CardVideoOperateListener;", "Lcom/ss/android/lark/widget/photopicker/gallery/callback/VideoOperateListener;", "sessionID", "", "<init>", "(Ljava/lang/String;)V", "onOperate", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "videoView", "Lcom/ss/android/lark/widget/photo/preview/video/online/IOnlineVideoGalleryContract$IView;", "actionID", "photoItem", "Lcom/ss/android/lark/widget/photopicker/entity/PhotoItem;", "isVideo", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CardVideoOperateListener implements VideoOperateListener {
        private final String sessionID;

        public CardVideoOperateListener(String r100) {
            Intrinsics.checkNotNullParameter(r100, "sessionID");
            this.sessionID = r100;
        }

        @Override // com.ss.android.lark.widget.photopicker.gallery.callback.VideoOperateListener, com.ss.android.lark.widget.photo.preview.callback.OperateListener
        public void onOperate(Context r100, String r101, PhotoItem r110, boolean r111) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "actionID");
            onOperate(r100, null, r101, r110, r111);
        }

        @Override // com.ss.android.lark.widget.photopicker.gallery.callback.VideoOperateListener
        public boolean onOperate(Context r100, com.ss.android.lark.widget.photo.preview.video.online.c r101, String r102, PhotoItem r103, boolean r104) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "actionID");
            if (Intrinsics.areEqual(r102, "SAVE_VIDEO") == true) goto L6;
            return false;
        L6:
            WeakReference<CardVideoServiceImpl> r105 = CardVideoServiceImpl.f283697c;
            if (r105 != null) goto L9;
        L15:
            Log.e("CardVideoService", a.a(this.sessionID) + " onOperate cannot find serviceRef");
            return true;
        L9:
            if (r105.get() == null) goto L15;
            String r106 = this.sessionID;
            Intrinsics.checkNotNullParameter(r106, "sessionID");
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (r103 != null) goto L13;
            Log.e("CardVideoService", a.a(r106) + " downloadVideoWithCheck photoItem is null");
            return true;
        L13:
            int r107 = DownloadCheckUtil.f447128a;
            f.a().o();
            throw null;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larksuite/component/card/component/video/service/CardVideoServiceImpl$FileState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "UNKNOWN", EffectConstants.NORMAL, "DELETED", "RECOVERABLE", "UNRECOVERABLE", "FREED_UP", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FileState extends Enum<FileState> {
        public static final FileState DELETED = null;
        public static final FileState FREED_UP = null;
        public static final FileState NORMAL = null;
        public static final FileState RECOVERABLE = null;
        public static final FileState UNKNOWN = null;
        public static final FileState UNRECOVERABLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FileState[] f283700a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f283701b = null;

        public static EnumEntries<FileState> getEntries() {
            return f283701b;
        }

        static {
            FileState r100 = new FileState("UNKNOWN", 0);
            UNKNOWN = r100;
            FileState r101 = new FileState(EffectConstants.NORMAL, 1);
            NORMAL = r101;
            FileState r102 = new FileState("DELETED", 2);
            DELETED = r102;
            FileState r103 = new FileState("RECOVERABLE", 3);
            RECOVERABLE = r103;
            FileState r104 = new FileState("UNRECOVERABLE", 4);
            UNRECOVERABLE = r104;
            FileState r105 = new FileState("FREED_UP", 5);
            FREED_UP = r105;
            FileState[] r110 = {r100, r101, r102, r103, r104, r105};
            f283700a = r110;
            f283701b = EnumEntriesKt.enumEntries(r110);
        }

        public static FileState[] values() {
            return (FileState[]) f283700a.clone();
        }

        public static FileState valueOf(String r100) {
            return (FileState) r27.a.a(FileState.class, r100);
        }

        public FileState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public a() {
        }

        public static final String a(String r100) {
            WeakReference<CardVideoServiceImpl> r101 = CardVideoServiceImpl.f283697c;
            return "[CardVideoService-" + r100 + ']';
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f283702a = null;

        static {
            int[] r100 = new int[GetFileStateResponse.State.values().length];
            r100[GetFileStateResponse.State.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[GetFileStateResponse.State.DELETED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[GetFileStateResponse.State.RECOVERABLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[GetFileStateResponse.State.UNRECOVERABLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[GetFileStateResponse.State.FREED_UP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f283702a = r100;
        }
    }

    public static final class c extends LruCache<String, FileState> {
        @Override // android.util.LruCache
        public final FileState create(String r100) {
            return null;
        }

        @Override // android.util.LruCache
        public final void entryRemoved(boolean r100, String r101, FileState r102, FileState r103) {
        }

        @Override // android.util.LruCache
        public final int sizeOf(String r100, FileState r101) {
            return 1;
        }

        public c() {
            super(100);
        }
    }

    static {
        new a();
    }

    @Override // com.larksuite.component.card.service.c
    public final void destroy() {
        CoroutineScopeKt.cancel$default(this.f283698a, "CardVideoServiceImpl destroy", null, 2, null);
        this.f283699b.evictAll();
        f283697c = null;
    }

    public CardVideoServiceImpl(com.larksuite.component.card.service.b r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceContext");
        this.f283698a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.f283699b = new c();
    }

    public static final Object m(CardVideoServiceImpl r100, final String r101, VideoInfo r102, Continuation r110) {
        r100.getClass();
        if ((r110 instanceof CardVideoServiceImpl$checkFileStateSuspend$1) == false) goto L7;
        CardVideoServiceImpl$checkFileStateSuspend$1 r103 = (CardVideoServiceImpl$checkFileStateSuspend$1) r110;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r111 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        String r107 = (String) r103.L$1;
        r101 = (String) r103.L$0;
        ResultKt.throwOnFailure(r111);
    L24:
        int r108 = b.f283702a[((GetFileStateResponse.State) r111).ordinal()];
        if (r108 != 1) goto L27;
        FileState r109 = FileState.NORMAL;
    L41:
        FileState r112 = r109;
        Log.i("CardVideoService", a.a(r101) + " checkFileStateSuspend fileState: " + r112);
        r100.f283699b.put(r101, r112);
        return r112;
    L27:
        if (r108 != 2) goto L29;
        r109 = FileState.DELETED;
        goto L41
    L29:
        if (r108 != 3) goto L31;
        r109 = FileState.RECOVERABLE;
        goto L41
    L31:
        if (r108 != 4) goto L33;
        r109 = FileState.UNRECOVERABLE;
        goto L41
    L33:
        if (r108 != 5) goto L36;
        r109 = FileState.FREED_UP;
        goto L41
    L36:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        FileState r113 = r100.f283699b.get(r101);
        if (r113 == null) goto L17;
        Log.i("CardVideoService", a.a(r101) + " checkFileStateSuspend from cache");
        return r113;
    L17:
        String r114 = r102.getUrl();
        if (r114 == null) goto L44;
        r103.L$0 = r101;
        r103.L$1 = r114;
        r103.label = 1;
        final j r115 = new j(IntrinsicsKt.intercepted(r103), 1);
        r115.C();
        SdkSender.asynSendRequestNonWrap(Command.GET_FILE_STATE_BY_URL, new GetFileStateByUrlRequest.Builder().url(r114).scene(DownloadFileScene.UniversalCard), new CardVideoServiceImpl$checkFileStateSuspend$sdkFileState$1$1(r101, r115), new com.larksuite.component.card.component.video.service.b(r101));
        r111 = r115.B();
        if (r111 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        DebugProbesKt.probeCoroutineSuspended(r103);
    L22:
        if (r111 != r105) goto L24;
        return r105;
    L44:
        throw new IllegalStateException("videoInfo.url is null");
    L7:
        r103 = new CardVideoServiceImpl$checkFileStateSuspend$1(r100, r110);
        goto L8
    }

    @Override // com.larksuite.component.card.component.video.service.c
    public final void d(CardContext r110, VideoInfo r111, RichTextElement.ImageProperty r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r110, "cardContext");
        Intrinsics.checkNotNullParameter(r111, "videoInfo");
        BuildersKt.launch$default(this.f283698a, null, null, new CardVideoServiceImpl$previewVideo$1(r111, this, r112, r110, r113, null), 3, null);
    }
}
