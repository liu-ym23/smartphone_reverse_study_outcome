package com.larus.kmp.voice_setting.voice.mix;

import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public interface x {

    public static final class a implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f353943a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final VoiceMixPlayVisualState f353944b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f353945c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f353946d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f353947e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f353943a, r101.f353943a) == true) goto L12;
            return false;
        L12:
            if (this.f353944b == r101.f353944b) goto L15;
            return false;
        L15:
            if (this.f353945c == r101.f353945c) goto L18;
            return false;
        L18:
            if (this.f353946d == r101.f353946d) goto L21;
            return false;
        L21:
            if (this.f353947e == r101.f353947e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f353943a.hashCode() * 31) + this.f353944b.hashCode()) * 31;
            int r101 = 1231;
            if (this.f353945c == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f353946d == false) goto L9;
            int r104 = 1231;
        L10:
            int r105 = (r103 + r104) * 31;
            if (this.f353947e == true) goto L15;
            r101 = 1237;
        L15:
            return r105 + r101;
        L9:
            r104 = 1237;
            goto L10
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "Collapsed(title=" + this.f353943a + ", playState=" + this.f353944b + ", showExpand=" + this.f353945c + ", showRemove=" + this.f353946d + ", showDivider=" + this.f353947e + ')';
        }

        public a(String r100, VoiceMixPlayVisualState r101, boolean r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "title");
            Intrinsics.checkNotNullParameter(r101, Keys.API_EVENT_KEY_PLAY_STATE);
            this.f353943a = r100;
            this.f353944b = r101;
            this.f353945c = r102;
            this.f353946d = true;
            this.f353947e = r103;
        }
    }

    public static final class b implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f353948a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f353948a, ((b) r100).f353948a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f353948a.hashCode();
        }

        public final String toString() {
            return "Empty(emptyText=" + this.f353948a + ')';
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "emptyText");
            this.f353948a = r100;
        }
    }
}
