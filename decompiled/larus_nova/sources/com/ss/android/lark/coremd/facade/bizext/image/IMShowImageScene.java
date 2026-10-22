package com.ss.android.lark.coremd.facade.bizext.image;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/coremd/facade/bizext/image/IMShowImageScene;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE_MODE_POST", "IMAGE_MODE_POST_DETAIL", "IMAGE_MODE_THREAD_TOPIC", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IMShowImageScene extends Enum<IMShowImageScene> {
    public static final IMShowImageScene IMAGE_MODE_POST = null;
    public static final IMShowImageScene IMAGE_MODE_POST_DETAIL = null;
    public static final IMShowImageScene IMAGE_MODE_THREAD_TOPIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IMShowImageScene[] f419639a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f419640b = null;

    public static EnumEntries<IMShowImageScene> getEntries() {
        return f419640b;
    }

    static {
        IMShowImageScene r100 = new IMShowImageScene("IMAGE_MODE_POST", 0);
        IMAGE_MODE_POST = r100;
        IMShowImageScene r101 = new IMShowImageScene("IMAGE_MODE_POST_DETAIL", 1);
        IMAGE_MODE_POST_DETAIL = r101;
        IMShowImageScene r102 = new IMShowImageScene("IMAGE_MODE_THREAD_TOPIC", 2);
        IMAGE_MODE_THREAD_TOPIC = r102;
        IMShowImageScene[] r103 = {r100, r101, r102};
        f419639a = r103;
        f419640b = EnumEntriesKt.enumEntries(r103);
    }

    public static IMShowImageScene[] values() {
        return (IMShowImageScene[]) f419639a.clone();
    }

    public static IMShowImageScene valueOf(String r100) {
        return (IMShowImageScene) r27.a.a(IMShowImageScene.class, r100);
    }

    public IMShowImageScene(String r100, int r101) {
        super(r100, r101);
    }
}
