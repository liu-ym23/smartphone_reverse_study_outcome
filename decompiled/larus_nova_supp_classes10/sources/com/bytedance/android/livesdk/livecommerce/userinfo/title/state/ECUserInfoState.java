package com.bytedance.android.livesdk.livecommerce.userinfo.title.state;

import com.bytedance.android.ec.live.api.commerce.userinfo.ECAuthorArea;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.bdlocation.trace.TraceCons;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECUserInfoState implements com.bytedance.android.ec.core.arch.state.b {
    public final b a;
    public final e b;
    public final c c;
    public final d d;
    public final a e;
    public final boolean f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/userinfo/title/state/ECUserInfoState$AnimStateEnum;", "", "NONE", "FOLLOWED_HIDING", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum AnimStateEnum extends Enum<AnimStateEnum> {
        public static final AnimStateEnum FOLLOWED_HIDING = null;
        public static final AnimStateEnum NONE = null;
        public static final /* synthetic */ AnimStateEnum[] a = null;

        static {
            AnimStateEnum r1 = new AnimStateEnum("NONE", 0);
            NONE = r1;
            AnimStateEnum r2 = new AnimStateEnum("FOLLOWED_HIDING", 1);
            FOLLOWED_HIDING = r2;
            a = new AnimStateEnum[]{r1, r2};
        }

        public static AnimStateEnum valueOf(String r1) {
            return (AnimStateEnum) r27.a.a(AnimStateEnum.class, r1);
        }

        public static AnimStateEnum[] values() {
            return (AnimStateEnum[]) a.clone();
        }

        public AnimStateEnum(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final AnimStateEnum a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((a) r2).a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            AnimStateEnum r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "AnimState(state=" + this.a + ")";
        }

        public a() {
            this(AnimStateEnum.NONE);
        }

        public a(AnimStateEnum r2) {
            Intrinsics.checkNotNullParameter(r2, BaseCoreViewModel.CORE_TAG_STATE);
            this.a = r2;
        }
    }

    public static final class b {
        public final ECUrlModel a;
        public final ECUrlModel b;

        public b() {
            this(null, null);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L10;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            ECUrlModel r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            ECUrlModel r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "AvatarState(avatarThumb=" + this.a + ", avatarBorder=" + this.b + ")";
        }

        public b(ECUrlModel r1, ECUrlModel r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c {
        public final Integer a;

        public c() {
            this(null);
        }

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof c) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((c) r2).a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            Integer r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "BackgroundState(backgroundColor=" + this.a + ")";
        }

        public c(Integer r1) {
            this.a = r1;
        }
    }

    public static final class d {
        public final List<ECAuthorArea.e> a;

        public d() {
            this(null);
        }

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof d) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((d) r2).a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            List<ECAuthorArea.e> r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "Introduction(introductionList=" + this.a + ")";
        }

        public d(List<ECAuthorArea.e> r1) {
            this.a = r1;
        }
    }

    public static final class e {
        public final String a;
        public final List<String> b;

        public e() {
            this(null, null);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof e) == false) goto L10;
            e r4 = (e) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            List<String> r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "NicknameState(nickname=" + this.a + ", nickColor=" + this.b + ")";
        }

        public e(String r1, List<String> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public ECUserInfoState() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ECUserInfoState) == false) goto L18;
        ECUserInfoState r4 = (ECUserInfoState) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        b r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        e r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        c r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        d r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        a r13 = this.e;
        if (r13 == null) goto L21;
        r1 = r13.hashCode();
    L21:
        int r14 = (r12 + r1) * 31;
        boolean r15 = this.f;
        ?? r16 = r15;
        if (r15 == false) goto L25;
        r16 = 1;
    L25:
        return r14 + r16;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ECUserInfoState(avatar=" + this.a + ", nickname=" + this.b + ", background=" + this.c + ", introduction=" + this.d + ", animState=" + this.e + ", hasInit=" + this.f + ")";
    }

    public /* synthetic */ ECUserInfoState(int r8) {
        this(new b(null, null), new e(null, null), new c(null), new d(null), new a(AnimStateEnum.NONE), false);
    }

    public ECUserInfoState(b r2, e r3, c r4, d r5, a r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "avatar");
        Intrinsics.checkNotNullParameter(r3, "nickname");
        Intrinsics.checkNotNullParameter(r4, TraceCons.METRIC_BACKGROUND);
        Intrinsics.checkNotNullParameter(r5, "introduction");
        Intrinsics.checkNotNullParameter(r6, "animState");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }

    public static ECUserInfoState a(ECUserInfoState r7, b r8, e r9, c r10, d r11, a r12, boolean r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        r8 = r7.a;
    L5:
        b r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r9 = r7.b;
    L8:
        e r2 = r9;
        if ((r14 & 4) == 0) goto L11;
        r10 = r7.c;
    L11:
        c r3 = r10;
        if ((r14 & 8) == 0) goto L14;
        r11 = r7.d;
    L14:
        d r4 = r11;
        if ((r14 & 16) == 0) goto L17;
        r12 = r7.e;
    L17:
        a r5 = r12;
        if ((r14 & 32) == 0) goto L20;
        r13 = r7.f;
    L20:
        r7.getClass();
        Intrinsics.checkNotNullParameter(r1, "avatar");
        Intrinsics.checkNotNullParameter(r2, "nickname");
        Intrinsics.checkNotNullParameter(r3, TraceCons.METRIC_BACKGROUND);
        Intrinsics.checkNotNullParameter(r4, "introduction");
        Intrinsics.checkNotNullParameter(r5, "animState");
        return new ECUserInfoState(r1, r2, r3, r4, r5, r13);
    }
}
