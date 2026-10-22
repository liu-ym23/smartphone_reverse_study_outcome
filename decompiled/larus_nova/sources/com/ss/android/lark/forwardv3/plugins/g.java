package com.ss.android.lark.forwardv3.plugins;

import com.huawei.hms.support.feature.result.CommonConstant;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public interface g {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f425507a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f425508b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f425509c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f425510d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f425511e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f425507a, r101.f425507a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f425508b, r101.f425508b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f425509c, r101.f425509c) == true) goto L18;
            return false;
        L18:
            if (this.f425510d == r101.f425510d) goto L21;
            return false;
        L21:
            if (this.f425511e == r101.f425511e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f425507a.hashCode() * 31) + this.f425508b.hashCode()) * 31) + this.f425509c.hashCode()) * 31;
            int r101 = 1231;
            if (this.f425510d == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f425511e == true) goto L11;
            r101 = 1237;
        L11:
            return r103 + r101;
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "ChatterInfo(chatterId=" + this.f425507a + ", displayName=" + this.f425508b + ", originName=" + this.f425509c + ", isOutChatUser=" + this.f425510d + ", isAnonymous=" + this.f425511e + ')';
        }

        public a(String r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "chatterId");
            Intrinsics.checkNotNullParameter(r101, CommonConstant.KEY_DISPLAY_NAME);
            Intrinsics.checkNotNullParameter("", "originName");
            this.f425507a = r100;
            this.f425508b = r101;
            this.f425509c = "";
            this.f425510d = r102;
            this.f425511e = false;
        }
    }

    public interface b {
        List<SearchBaseInfo> a();
    }

    void a();
}
