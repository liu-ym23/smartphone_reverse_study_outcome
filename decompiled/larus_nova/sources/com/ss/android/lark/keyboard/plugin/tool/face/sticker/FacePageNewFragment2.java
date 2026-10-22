package com.ss.android.lark.keyboard.plugin.tool.face.sticker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import com.ss.android.lark.keyboard.plugin.tool.face.FaceEmptyView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 K2\u00020\u0001:\u0002JKB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u001e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0006\u0010(\u001a\u00020&J\u0010\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020&H\u0002J\b\u0010-\u001a\u00020&H\u0002J\b\u0010.\u001a\u00020&H\u0002J\b\u0010/\u001a\u00020&H\u0002J\b\u00100\u001a\u00020&H\u0002J\b\u00101\u001a\u00020&H\u0002J\b\u00102\u001a\u00020&H\u0002J\u0016\u00103\u001a\u00020&2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001105H\u0002J\b\u00106\u001a\u00020&H\u0016J\"\u00107\u001a\u00020&2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002092\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u001e\u0010=\u001a\u00020&2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020?052\u0006\u0010@\u001a\u00020\u0019H\u0002J\u0010\u0010A\u001a\u00020&2\b\u0010B\u001a\u0004\u0018\u00010\u0006J\u0010\u0010C\u001a\u00020&2\b\u0010D\u001a\u0004\u0018\u00010\bJ\b\u0010E\u001a\u00020&H\u0002J\b\u0010F\u001a\u00020&H\u0002J\b\u0010G\u001a\u00020&H\u0002J\n\u0010H\u001a\u0004\u0018\u00010\bH\u0002J\n\u0010I\u001a\u0004\u0018\u00010\u0006H\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/face/sticker/FacePageNewFragment2;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "mRefOnOperationListener", "Ljava/lang/ref/WeakReference;", "Lcom/ss/android/lark/keyboard/plugin/tool/face/OnOperationListener;", "mRefStickerDependency", "Lcom/ss/android/lark/keyboard/plugin/tool/face/sticker/IStickerDependency;", "mRootView", "Landroid/view/View;", "mEmptyView", "Lcom/ss/android/lark/keyboard/plugin/tool/face/FaceEmptyView;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mDatas", "", "Lcom/ss/android/lark/chat/entity/sticker/Sticker;", "mAdapter", "Lcom/ss/android/lark/keyboard/plugin/tool/face/sticker/FaceNewAdapter;", "getMAdapter", "()Lcom/ss/android/lark/keyboard/plugin/tool/face/sticker/FaceNewAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "isNeedLoadSticker", "", "mPushStickerListener", "Lcom/ss/android/lark/keyboard/plugin/tool/face/IPushStickerListener;", "mPushStickerListenerWrapper", "Lcom/ss/android/lark/keyboard/plugin/tool/face/sticker/FacePageNewFragment2$PushStickerListenerWrapper;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onPanelShow", "createRootView", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "initWidget", "initListener", "initData", "initPush", "updateContentView", "loadStickers", "forceLoadStickers", "initStickerList", "stickers", "", "onDestroyView", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "uploadStickers", "photos", "", "keepOriginal", "setOnOperationListener", "onOperationListener", "setStickerDependency", "stickerDependency", "setFaceSelectedListener", "setLocalStickerFileInfoProvider", "setGlideStickerLoader", "getStickerDependency", "getOnOperationListener", "PushStickerListenerWrapper", "Companion", "keyboard-biz-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FacePageNewFragment2 extends BaseFragment {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f429672n = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference<com.ss.android.lark.keyboard.plugin.tool.face.b> f429673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WeakReference<k> f429674e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f429675f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FaceEmptyView f429676g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RecyclerView f429677h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<Sticker> f429678i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f429679j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f429680k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f429681l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f429682m;

    public static final class a {
    }

    public static final class b {
        public b(c r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            new WeakReference(r100);
        }
    }

    public static final class c {
        public c() {
        }
    }

    static {
    }

    public final FaceNewAdapter T90() {
        return (FaceNewAdapter) this.f429679j.getValue();
    }

    public final k U90() {
        WeakReference<k> r100 = this.f429674e;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    public final void Y90() {
        RecyclerView r100 = null;
        if (((ArrayList) this.f429678i).size() != 1) goto L12;
        FaceEmptyView r101 = this.f429676g;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyView");
        r101 = null;
    L7:
        r101.setVisibility(0);
        RecyclerView r102 = this.f429677h;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L11:
        r100.setVisibility(8);
        return;
    L10:
        r100 = r102;
        goto L11
    L12:
        FaceEmptyView r103 = this.f429676g;
        if (r103 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyView");
        r103 = null;
    L15:
        r103.setVisibility(8);
        RecyclerView r104 = this.f429677h;
        if (r104 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L19:
        r100.setVisibility(0);
        return;
    L18:
        r100 = r104;
        goto L19
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        Log.i("FacePageNewFragment2", "onDestroyView");
        k r100 = U90();
        if (r100 == null) goto L5;
        r100.e();
    L5:
        FaceNewAdapter r101 = T90();
        r101.f429664g = null;
        r101.f429665h = null;
        r101.f429663f = null;
        super.onDestroyView();
    }

    public FacePageNewFragment2() {
        this.f429678i = new ArrayList();
        this.f429679j = LazyKt.lazy(new FacePageNewFragment2$mAdapter$2(this));
        this.f429681l = new c();
    }

    public final void V90() {
        if (isAdded() == false) goto L9;
        FaceNewAdapter r100 = T90();
        h r101 = new h(this);
        if (r100.f429664g != null) goto L10;
        r100.f429664g = r101;
        return;
    L10:
        return;
    }

    public final void W90() {
        if (isAdded() == false) goto L9;
        FaceNewAdapter r100 = T90();
        i r101 = new i(this);
        if (r100.f429665h != null) goto L10;
        r100.f429665h = r101;
        return;
    L10:
        return;
    }

    public final void X90() {
        if (isAdded() == false) goto L9;
        FaceNewAdapter r100 = T90();
        j r101 = new j(this);
        if (r100.f429663f != null) goto L10;
        r100.f429663f = r101;
        return;
    L10:
        return;
    }

    public static final void S90(FacePageNewFragment2 r100, List r101) {
        ((ArrayList) r100.f429678i).clear();
        Sticker r102 = new Sticker();
        ((ArrayList) r100.f429678i).add(r102);
        ArrayList r103 = (ArrayList) r100.f429678i;
        r103.addAll(r101);
        r100.T90().setData(r100.f429678i);
        r100.Y90();
    }

    public final void Z90(final List<String> r100, final boolean r101) {
        k r102 = U90();
        if (r102 != null) goto L7;
        Log.i("FacePageNewFragment2", "uploadStickers called. stickerDependency is null.");
        return;
    L7:
        if (r100.isEmpty() == false) goto L9;
        return;
    L9:
        this.mCallbackManager.wrapAndAddGetDataCallback(new FacePageNewFragment2$uploadStickers$uiGetDataCallback$1(r100, this, r101));
        int r103 = r100.size();
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L15;
        Sticker r105 = new Sticker();
        r105.setStickerId("-1");
        ((ArrayList) this.f429678i).add(r105);
        String r106 = (String) ListProtector.get(r100, r104);
        if (TextUtils.isEmpty(r106) == true) goto L14;
        VFSFile r107 = VFSFiles.f444819b.i(r106);
        String[] r108 = FileUtils.f285888a;
        r107.length();
    L14:
        r104 = r104 + 1;
        goto L10
    L15:
        T90().setData(this.f429678i);
        r102.a();
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Log.i("FacePageNewFragment2", "onViewCreated");
        if (this.f429680k == false) goto L9;
        k r102 = U90();
        if (r102 == null) goto L10;
        Log.i("FacePageNewFragment2", "loadStickers");
        this.f429680k = false;
        final Ref.BooleanRef r103 = new Ref.BooleanRef();
        final long r104 = SystemClock.elapsedRealtime();
        new FacePageNewFragment2$loadStickers$1(r104, r103, this);
        r102.g();
        final long r105 = SystemClock.elapsedRealtime();
        new FacePageNewFragment2$loadStickers$2(r105, r103, this);
        r102.g();
        return;
    L10:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        if (r101 == (-1)) goto L5;
        return;
    L5:
        boolean r103 = true;
        if (r102 != null) goto L8;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == true) goto L14;
        return;
    L14:
        if (r100 != 1024) goto L24;
        ArrayList<String> r105 = r102.getStringArrayListExtra("SELECTED_PHOTOS");
        if (r105 != null) goto L18;
    L20:
        r103 = false;
    L21:
        if (r103 == false) goto L25;
        Z90(r105, r102.getBooleanExtra("KEEP_ORIGIN_PHOTO", false));
        return;
    L25:
        return;
    L18:
        if ((!r105.isEmpty()) != true) goto L20;
    L24:
        return;
    L8:
        if (r102.getBooleanExtra("KEY_FOR_SEND", false) != true) goto L10;
        r104 = true;
        goto L11
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Log.i("FacePageNewFragment2", "onCreateView");
        if (this.f429675f != null) goto L17;
        Context r103 = r100.getContext();
        LinearLayout r104 = new LinearLayout(r103);
        r104.setId(R.id.root);
        ViewGroup.LayoutParams r105 = new ViewGroup.LayoutParams(-1, -1);
        r104.setOrientation(1);
        r104.setLayoutParams(r105);
        FaceEmptyView r106 = new FaceEmptyView(r103);
        r106.setId(R.id.face_empty_view);
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(-2, -2);
        r107.gravity = 17;
        r107.topMargin = UIUtils.dp2px(r103, 48.0f);
        r106.setGravity(17);
        r104.addView(r106, r107);
        this.f429677h = new RecyclerView(r103);
        FrameLayout.LayoutParams r108 = new FrameLayout.LayoutParams(-1, -1);
        RecyclerView r109 = this.f429677h;
        if (r109 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r109 = null;
    L7:
        r109.setVisibility(8);
        FrameLayout r110 = new FrameLayout(r103);
        RecyclerView r111 = this.f429677h;
        if (r111 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r111 = null;
    L10:
        r110.addView(r111, r108);
        r104.addView(r110, new LinearLayout.LayoutParams(-1, -1));
        this.f429675f = r104;
        this.f429676g = (FaceEmptyView) r104.findViewById(R.id.face_empty_view);
        final Context r112 = getContext();
        GridLayoutManager r113 = new FacePageNewFragment2$initWidget$layoutManager$1(r112);
        RecyclerView r114 = this.f429677h;
        if (r114 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r114 = null;
    L13:
        r114.setLayoutManager(r113);
        RecyclerView r115 = this.f429677h;
        if (r115 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r115 = null;
    L16:
        r115.setAdapter(T90());
    L17:
        FaceEmptyView r116 = this.f429676g;
        if (r116 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyView");
        r116 = null;
    L20:
        r116.setOnClickListener(new g(this));
        V90();
        X90();
        W90();
        T90().setData(this.f429678i);
        Y90();
        if (this.f429682m != null) goto L23;
        this.f429682m = new b(this.f429681l);
    L23:
        k r117 = U90();
        if (r117 == null) goto L26;
        r117.e();
        r117.f();
    L26:
        View r118 = this.f429675f;
        if (r118 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        return null;
    L30:
        return r118;
    }
}
