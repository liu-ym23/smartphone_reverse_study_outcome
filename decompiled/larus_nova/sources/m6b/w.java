package m6b;

import com.bytedance.lark.pb.im.v1.PushMessageResponse;

/* JADX INFO: loaded from: classes35.dex */
public final /* synthetic */ class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f512310a = null;

    static {
        int[] r100 = new int[PushMessageResponse.MessageItem.ItemType.values().length];
        r100[PushMessageResponse.MessageItem.ItemType.EPHEMERAL_MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
    L15:
        r100[PushMessageResponse.MessageItem.ItemType.NORMAL_MESSAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
    L23:
        r100[PushMessageResponse.MessageItem.ItemType.QUASI_MESSAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
    L17:
        r100[PushMessageResponse.MessageItem.ItemType.MESSAGE_FOLD.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
    L19:
        r100[PushMessageResponse.MessageItem.ItemType.UNKNOWN_MESSAGE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
    L8:
        f512310a = r100;
    }
}
