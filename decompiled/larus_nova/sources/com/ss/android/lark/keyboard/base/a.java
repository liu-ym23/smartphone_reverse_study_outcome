package com.ss.android.lark.keyboard.base;

import com.bytedance.lark.pb.basic.v1.DraftAttachmentSnapshot;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C5076a f428227b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DraftAttachmentSnapshot f428228a;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.base.a$a, reason: collision with other inner class name */
    public static final class C5076a implements n.a<a> {
        public C5076a() {
        }
    }

    static {
        f428227b = new C5076a();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f428228a, ((a) r100).f428228a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        DraftAttachmentSnapshot r100 = this.f428228a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "DraftAttachmentInfo(attachmentSnapshot=" + this.f428228a + ')';
    }

    public a(DraftAttachmentSnapshot r100) {
        this.f428228a = r100;
    }
}
