package com.larus.drive.biz.impl.search.kmp;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.DrivePayload;
import ei9.f;
import ei9.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DrivePayload f341245a;

    /* JADX INFO: renamed from: com.larus.drive.biz.impl.search.kmp.a$a, reason: collision with other inner class name */
    public static final class C4299a implements g<ISearchDataPayload, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C4299a f341246a = null;

        static {
            f341246a = new C4299a();
        }

        public C4299a() {
        }

        @Override // ei9.g
        public final boolean a(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if (r101.getType() != 2) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // ei9.g
        public final f b(ISearchDataPayload r110) {
            ISearchDataPayload r100 = r110;
            Intrinsics.checkNotNullParameter(r100, "sourceData");
            if ((r100 instanceof DrivePayload) == false) goto L5;
            DrivePayload r101 = (DrivePayload) r100;
        L6:
            if (r101 != null) goto L9;
            r101 = new DrivePayload("", null, null, null, null, 0, null, null, null, 0, null, null, 0, null, 32766);
        L9:
            return new a(r101);
        L5:
            r101 = null;
            goto L6
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f341245a, ((a) r100).f341245a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f341245a.hashCode();
    }

    public final String toString() {
        return "KmpDriveSearchCellState(payload=" + this.f341245a + ')';
    }

    public a(DrivePayload r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        this.f341245a = r100;
    }
}
