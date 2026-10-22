package com.ss.android.lark.chat.chatwindow.chat.v2.component.message;

import androidx.recyclerview.widget.RecyclerView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.ErrorLevel;
import com.ss.android.lark.appreciablelib.ErrorParams;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatImageErrDetector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentMap<b, Boolean> f413592a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<b, String> f413593b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static WeakReference<RecyclerView> f413594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static WeakReference<com.ss.android.lark.chat.chatwindow.chat.a> f413595d;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/ChatImageErrDetector$ErrorType;", "", "code", "", "errorMsg", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "TYPE_EXIT_CHAT", "TYPE_SUCCESS", "TYPE_DATA_LIST_EMPTY", "TYPE_MESSAGE_RECALL", "TYPE_MESSAGE_NOT_IMAGE", "TYPE_IMAGE_SET_EMPTY", "TYPE_IMAGE_EMPTY", "TYPE_IMAGE_KEY_NOT_EQUAL", "TYPE_MESSAGE_NOT_EXIST", "TYPE_IMAGE_LOAD_REAL_FAILED", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ErrorType extends Enum<ErrorType> {
        public static final ErrorType TYPE_DATA_LIST_EMPTY = null;
        public static final ErrorType TYPE_EXIT_CHAT = null;
        public static final ErrorType TYPE_IMAGE_EMPTY = null;
        public static final ErrorType TYPE_IMAGE_KEY_NOT_EQUAL = null;
        public static final ErrorType TYPE_IMAGE_LOAD_REAL_FAILED = null;
        public static final ErrorType TYPE_IMAGE_SET_EMPTY = null;
        public static final ErrorType TYPE_MESSAGE_NOT_EXIST = null;
        public static final ErrorType TYPE_MESSAGE_NOT_IMAGE = null;
        public static final ErrorType TYPE_MESSAGE_RECALL = null;
        public static final ErrorType TYPE_SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ErrorType[] f413596a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f413597b = null;
        private final int code;
        private final String errorMsg;

        public static EnumEntries<ErrorType> getEntries() {
            return f413597b;
        }

        static {
            ErrorType r100 = new ErrorType("TYPE_EXIT_CHAT", 0, 100, "user exit chat");
            TYPE_EXIT_CHAT = r100;
            ErrorType r101 = new ErrorType("TYPE_SUCCESS", 1, 101, "load success");
            TYPE_SUCCESS = r101;
            ErrorType r102 = new ErrorType("TYPE_DATA_LIST_EMPTY", 2, 102, "data list empty");
            TYPE_DATA_LIST_EMPTY = r102;
            ErrorType r103 = new ErrorType("TYPE_MESSAGE_RECALL", 3, 103, "message recall");
            TYPE_MESSAGE_RECALL = r103;
            ErrorType r104 = new ErrorType("TYPE_MESSAGE_NOT_IMAGE", 4, 104, "message not image");
            TYPE_MESSAGE_NOT_IMAGE = r104;
            ErrorType r105 = new ErrorType("TYPE_IMAGE_SET_EMPTY", 5, 105, "imageSet is empty");
            TYPE_IMAGE_SET_EMPTY = r105;
            ErrorType r106 = new ErrorType("TYPE_IMAGE_EMPTY", 6, 106, "image is empty");
            TYPE_IMAGE_EMPTY = r106;
            ErrorType r110 = new ErrorType("TYPE_IMAGE_KEY_NOT_EQUAL", 7, 107, "image key is not equal");
            TYPE_IMAGE_KEY_NOT_EQUAL = r110;
            ErrorType r111 = new ErrorType("TYPE_MESSAGE_NOT_EXIST", 8, 108, "message not exist");
            TYPE_MESSAGE_NOT_EXIST = r111;
            ErrorType r112 = new ErrorType("TYPE_IMAGE_LOAD_REAL_FAILED", 9, -1, "image load real failed");
            TYPE_IMAGE_LOAD_REAL_FAILED = r112;
            ErrorType[] r113 = {r100, r101, r102, r103, r104, r105, r106, r110, r111, r112};
            f413596a = r113;
            f413597b = EnumEntriesKt.enumEntries(r113);
        }

        public static ErrorType[] values() {
            return (ErrorType[]) f413596a.clone();
        }

        public final int getCode() {
            return this.code;
        }

        public final String getErrorMsg() {
            return this.errorMsg;
        }

        public static ErrorType valueOf(String r100) {
            return (ErrorType) r27.a.a(ErrorType.class, r100);
        }

        public ErrorType(String r100, int r101, int r102, String r103) {
            super(r100, r101);
            this.code = r102;
            this.errorMsg = r103;
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f413598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f413599b;

        public final int hashCode() {
            return Objects.hash(new Object[]{this.f413598a, this.f413599b});
        }

        public final String toString() {
            return "DetectData(msgId=" + this.f413598a + ", imageKey=" + this.f413599b + ')';
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f413598a, r101.f413598a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f413599b, r101.f413599b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
            Intrinsics.checkNotNullParameter(r101, "imageKey");
            this.f413598a = r100;
            this.f413599b = r101;
        }
    }

    public ChatImageErrDetector() {
    }

    static {
        f413592a = new ConcurrentHashMap();
        f413593b = new ConcurrentHashMap();
    }

    public static void a(String r210, String r211, ErrorType r212, ErrorResult r213) {
        ConcurrentHashMap<b, String> r100 = f413593b;
        if (r100.get(new b(r210, r211)) != null) goto L7;
        Log.i("ChatImageDetector", "report key is empty, msgId:" + r210 + ", imageKey:" + r211 + ", errorType:" + r212);
        return;
    L7:
        if (r213 == null) goto L9;
        int r101 = r213.getErrorCode();
    L10:
        int r110 = r101;
        AppreciableKit r102 = AppreciableKit.Companion.getInstance();
        Biz r103 = Biz.Messenger;
        Scene r104 = Scene.Chat;
        Event r105 = Event.image_load_real_failed;
        com.ss.android.lark.appreciablelib.ErrorType r106 = com.ss.android.lark.appreciablelib.ErrorType.Unknown;
        ErrorLevel r111 = ErrorLevel.Fatal;
        String r112 = r212.getErrorMsg();
        Boolean r107 = Boolean.TRUE;
        HashMap r113 = new HashMap();
        r113.put(MusicAppletPage.KEY_MESSAGE_ID, r210);
        r113.put("image_key", r211);
        r102.error(new ErrorParams(r103, r104, r105, r106, r111, r110, null, "ChatWindow", r112, r107, null, r113, null));
        r100.remove(new b(r210, r211));
        ((ConcurrentHashMap) f413592a).remove(new b(r210, r211));
        return;
    L9:
        r101 = r212.getCode();
        goto L10
    }
}
