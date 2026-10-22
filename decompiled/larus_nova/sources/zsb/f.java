package zsb;

import com.bytedance.lark.pb.basic.v1.MessageData;

/* JADX INFO: loaded from: classes36.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f573509a = null;

    static {
        int[] r100 = new int[MessageData.Type.values().length];
        f573509a = r100;
        r100[MessageData.Type.AT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
    L14:
        f573509a[MessageData.Type.URGENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
    L18:
        f573509a[MessageData.Type.REACTION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
    L22:
        f573509a[MessageData.Type.URGENT_ACK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
    L16:
        f573509a[MessageData.Type.URGENT_FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
        return;
    }
}
