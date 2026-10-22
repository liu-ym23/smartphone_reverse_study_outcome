package com.larus.drive.biz.impl.search.kmp;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.RecentDrivePayload;
import ei9.f;
import ei9.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecentDrivePayload f341247a;

    public static final class a implements g<ISearchDataPayload, b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f341248a = null;

        static {
            f341248a = new a();
        }

        public a() {
        }

        @Override // ei9.g
        public final boolean a(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if (r101.getType() != 114) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // ei9.g
        public final f b(ISearchDataPayload r100) {
            ISearchDataPayload r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "sourceData");
            if ((r101 instanceof RecentDrivePayload) == false) goto L5;
            RecentDrivePayload r102 = (RecentDrivePayload) r101;
        L6:
            if (r102 != null) goto L9;
            r102 = new RecentDrivePayload(0);
        L9:
            return new b(r102);
        L5:
            r102 = null;
            goto L6
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f341247a, ((b) r100).f341247a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f341247a.hashCode();
    }

    public final String toString() {
        return "KmpRecentDriveCellState(payload=" + this.f341247a + ')';
    }

    public b(RecentDrivePayload r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        this.f341247a = r100;
    }
}
