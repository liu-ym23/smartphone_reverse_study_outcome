package ifa;

import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.block.AttachmentItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f489643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AttachmentItem f489644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UplinkFileEntity f489645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f489646d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f489643a, r101.f489643a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f489644b, r101.f489644b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f489645c, r101.f489645c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f489646d, r101.f489646d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f489643a.hashCode() * 31) + this.f489644b.hashCode()) * 31) + this.f489645c.hashCode()) * 31;
        String r101 = this.f489646d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "HeaderAttachment(displayKey=" + this.f489643a + ", attachmentItem=" + this.f489644b + ", entity=" + this.f489645c + ", localPath=" + this.f489646d + ')';
    }

    public a(String r100, AttachmentItem r101, UplinkFileEntity r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "displayKey");
        Intrinsics.checkNotNullParameter(r101, "attachmentItem");
        Intrinsics.checkNotNullParameter(r102, "entity");
        this.f489643a = r100;
        this.f489644b = r101;
        this.f489645c = r102;
        this.f489646d = r103;
    }
}
