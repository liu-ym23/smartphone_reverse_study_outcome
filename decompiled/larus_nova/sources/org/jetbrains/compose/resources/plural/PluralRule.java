package org.jetbrains.compose.resources.plural;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes42.dex */
public final class PluralRule {

    public static abstract class Condition {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f525849a = 0;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lorg/jetbrains/compose/resources/plural/PluralRule$Condition$Operand;", "", "<init>", "(Ljava/lang/String;I)V", "N", "I", "V", ExifInterface.LONGITUDE_WEST, FaceService.girlLabel, ExifInterface.GPS_DIRECTION_TRUE, "C", "library_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Operand extends Enum<Operand> {
            public static final Operand C = null;
            public static final Operand F = null;
            public static final Operand I = null;
            public static final Operand N = null;
            public static final Operand T = null;
            public static final Operand V = null;
            public static final Operand W = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Operand[] f525850a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f525851b = null;

            public static EnumEntries<Operand> getEntries() {
                return f525851b;
            }

            static {
                Operand r100 = new Operand("N", 0);
                N = r100;
                Operand r101 = new Operand("I", 1);
                I = r101;
                Operand r102 = new Operand("V", 2);
                V = r102;
                Operand r103 = new Operand(ExifInterface.LONGITUDE_WEST, 3);
                W = r103;
                Operand r104 = new Operand(FaceService.girlLabel, 4);
                F = r104;
                Operand r105 = new Operand(ExifInterface.GPS_DIRECTION_TRUE, 5);
                T = r105;
                Operand r110 = new Operand("C", 6);
                C = r110;
                Operand[] r111 = {r100, r101, r102, r103, r104, r105, r110};
                f525850a = r111;
                f525851b = EnumEntriesKt.enumEntries(r111);
            }

            public static Operand[] values() {
                return (Operand[]) f525850a.clone();
            }

            public static Operand valueOf(String r100) {
                return (Operand) r27.a.a(Operand.class, r100);
            }

            public Operand(String r100, int r101) {
                super(r100, r101);
            }
        }

        public static final class a extends Condition {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Condition f525852b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Condition f525853c;

            @Override // org.jetbrains.compose.resources.plural.PluralRule.Condition
            public final Condition b() {
                Condition r100 = this.f525852b.b();
                c r101 = c.f525854b;
                if (Intrinsics.areEqual(r100, r101) == false) goto L5;
                return r101;
            L5:
                Condition r102 = this.f525853c.b();
                g r103 = g.f525864b;
                if (Intrinsics.areEqual(r100, r103) == false) goto L9;
                return r102;
            L9:
                if (Intrinsics.areEqual(r102, r101) == false) goto L12;
                return r101;
            L12:
                if (Intrinsics.areEqual(r102, r103) == false) goto L15;
                return r100;
            L15:
                if (r100.a(r102) == false) goto L18;
                return r100;
            L18:
                return new a(r100, r102);
            }

            public final String toString() {
                return this.f525852b + " and " + this.f525853c;
            }

            @Override // org.jetbrains.compose.resources.plural.PluralRule.Condition
            public final boolean a(Condition r100) {
                Intrinsics.checkNotNullParameter(r100, "other");
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L8;
                return false;
            L8:
                a r101 = (a) r100;
                if (this.f525852b.a(r101.f525852b) == true) goto L11;
            L13:
                return false;
            L11:
                if (this.f525853c.a(r101.f525853c) == false) goto L13;
                return true;
            }

            public a(Condition r100, Condition r101) {
                Intrinsics.checkNotNullParameter(r100, "left");
                Intrinsics.checkNotNullParameter(r101, "right");
                this.f525852b = r100;
                this.f525853c = r101;
            }
        }

        public static final class b {
        }

        public static final class c extends Condition {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final c f525854b = null;

            static {
                f525854b = new c();
            }

            @Override // org.jetbrains.compose.resources.plural.PluralRule.Condition
            public final Condition b() {
                return this;
            }

            public final String toString() {
                return "(false)";
            }

            public c() {
            }

            @Override // org.jetbrains.compose.resources.plural.PluralRule.Condition
            public final boolean a(Condition r100) {
                Intrinsics.checkNotNullParameter(r100, "other");
                return Intrinsics.areEqual(this, r100);
            }
        }

        public static final class d extends Condition {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Condition f525855b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Condition f525856c;

            @Override // org.jetbrains.compose.resources.plural.PluralRule.Condition
            public final Condition b() {
                Condition r100 = this.f525855b.b();
                g r101 = g.f525864b;
                if (Intrinsics.areEqual(r100, r101) == false) goto L5;
                return r101;
            L5:
                Condition r102 = this.f525856c.b();
                c r103 = c.f525854b;
                if (Intrinsics.areEqual(r100, r103) == false) goto L9;
                return r102;
            L9:
                if (Intrinsics.areEqual(r102, r101) == false) goto L12;
                return r101;
            L12:
                if (Intrinsics.areEqual(r102, r103) == false) goto L15;
                return r100;
            L15:
                if (r100.a(r102) == false) goto L18;
                return r100;
            L18:
                return new d(r100, r102);
            }

            public final String toString() {
                return this.f525855b + " or " + this.f525856c;
            }

            @Override // org.jetbrains.compose.resources.plural.PluralRule.Condition
            public final boolean a(Condition r100) {
                Intrinsics.checkNotNullParameter(r100, "other");
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof d) == true) goto L8;
                return false;
            L8:
                d r101 = (d) r100;
                if (this.f525855b.a(r101.f525855b) == true) goto L11;
            L13:
                return false;
            L11:
                if (this.f525856c.a(r101.f525856c) == false) goto L13;
                return true;
            }

            public d(Condition r100, Condition r101) {
                Intrinsics.checkNotNullParameter(r100, "left");
                Intrinsics.checkNotNullParameter(r101, "right");
                this.f525855b = r100;
                this.f525856c = r101;
            }
        }

        public static final class e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f525857a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f525858b;

            public final void d() {
            L3:
                if (this.f525858b < this.f525857a.length()) goto L5;
                boolean r100 = true;
            L6:
                if (r100 == true) goto L10;
                if (CharsKt.isWhitespace(this.f525857a.charAt(this.f525858b)) == false) goto L13;
                this.f525858b++;
                goto L3
            L13:
                return;
            L10:
                return;
            L5:
                r100 = false;
                goto L6
            }

            public final char h() {
                Character r100 = StringsKt.getOrNull(this.f525857a, this.f525858b);
                if (r100 == null) goto L7;
                return r100.charValue();
            L7:
                throw new PluralRuleParseException(this.f525857a, this.f525858b + 1);
            }

            public final char b() {
                char r100 = h();
                this.f525858b++;
                return r100;
            }

            public final int c() {
                a(Character.isDigit(h()));
                int r100 = this.f525858b;
                int r101 = 0;
            L4:
                if (r100 >= this.f525857a.length()) goto L8;
                if (Character.isDigit(this.f525857a.charAt(r100)) == false) goto L8;
                r101 = (r101 * 10) + (this.f525857a.charAt(r100) - '0');
                r100 = r100 + 1;
            L8:
                this.f525858b = r100;
                return r101;
            }

            public final Condition e() {
                Condition r100 = g();
            L3:
                d();
                Character r101 = StringsKt.getOrNull(this.f525857a, this.f525858b);
                if (r101 == null) goto L8;
                if (r101.charValue() != 'a') goto L8;
                b();
                boolean r102 = false;
                if (b() != 'n') goto L12;
                boolean r103 = true;
            L13:
                a(r103);
                if (b() != 'd') goto L16;
                r102 = true;
            L16:
                a(r102);
                r100 = new a(r100, g());
                goto L3
            L12:
                r103 = false;
            L8:
                return r100;
            }

            public final IntRange f() {
                d();
                int r100 = c();
                Character r101 = StringsKt.getOrNull(this.f525857a, this.f525858b);
                if (r101 == null) goto L8;
                if (r101.charValue() != '.') goto L8;
                b();
                if (b() != '.') goto L12;
                boolean r102 = true;
            L13:
                a(r102);
                return new IntRange(r100, c());
            L12:
                r102 = false;
            L8:
                return new IntRange(r100, r100);
            }

            public final f g() {
                d();
                char r100 = b();
                if (r100 != 'c') goto L5;
            L26:
                Operand r101 = Operand.C;
            L27:
                d();
                if (h() != '%') goto L30;
                b();
                d();
                Integer r102 = Integer.valueOf(c());
            L31:
                d();
                char r103 = h();
                if (r103 == '!') goto L37;
                if (r103 != '=') goto L36;
                b();
                boolean r104 = false;
            L42:
                List r105 = CollectionsKt.mutableListOf(new IntRange[]{f()});
            L43:
                Character r106 = StringsKt.getOrNull(this.f525857a, this.f525858b);
                if (r106 == null) goto L50;
                if (r106.charValue() != ',') goto L50;
                b();
                r105.add(f());
            L50:
                return new f(r101, r102, r104, (IntRange[]) r105.toArray(new IntRange[0]));
            L36:
                throw new PluralRuleParseException(this.f525857a, this.f525858b + 1);
            L37:
                b();
                if (b() != '=') goto L40;
                boolean r107 = true;
            L41:
                a(r107);
                r104 = true;
                goto L42
            L40:
                r107 = false;
                goto L41
            L30:
                r102 = null;
                goto L31
            L5:
                if (r100 != 'i') goto L7;
                r101 = Operand.I;
                goto L27
            L7:
                if (r100 != 'n') goto L9;
                r101 = Operand.N;
                goto L27
            L9:
                if (r100 != 't') goto L11;
                r101 = Operand.T;
                goto L27
            L11:
                if (r100 == 'e') goto L26;
                if (r100 != 'f') goto L15;
                r101 = Operand.F;
                goto L27
            L15:
                if (r100 != 'v') goto L17;
                r101 = Operand.V;
                goto L27
            L17:
                if (r100 != 'w') goto L20;
                r101 = Operand.W;
                goto L27
            L20:
                throw new PluralRuleParseException(this.f525857a, this.f525858b + 1);
            }

            public e(String r100) {
                Intrinsics.checkNotNullParameter(r100, "description");
                this.f525857a = r100;
            }

            public final void a(boolean r100) {
                if (r100 == false) goto L5;
                return;
            L5:
                throw new PluralRuleParseException(this.f525857a, this.f525858b + 1);
            }
        }

        public static final class f extends Condition {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Operand f525859b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Integer f525860c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final boolean f525861d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final IntRange[] f525862e;

            public /* synthetic */ class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f525863a = null;

                static {
                    int[] r100 = new int[Operand.values().length];
                    r100[Operand.N.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
                L9:
                    r100[Operand.I.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
                L5:
                    f525863a = r100;
                }
            }

            @Override // org.jetbrains.compose.resources.plural.PluralRule.Condition
            public final Condition b() {
                Operand r100 = this.f525859b;
                int r101 = a.f525863a[r100.ordinal()];
                boolean r102 = true;
                if (r101 == 1) goto L22;
                if (r101 == 2) goto L22;
                IntRange[] r103 = this.f525862e;
                int r104 = r103.length;
                int r105 = 0;
            L7:
                if (r105 >= r104) goto L16;
                IntRange r106 = r103[r105];
                int r107 = r106.getFirst();
                if (r106.getLast() < 0) goto L12;
                if (r107 > 0) goto L12;
                boolean r108 = true;
            L13:
                if (r108 == true) goto L18;
                r105 = r105 + 1;
            L18:
                if (r102 == this.f525861d) goto L26;
                return g.f525864b;
            L26:
                return c.f525854b;
            L12:
                r108 = false;
                goto L13
            L16:
                r102 = false;
            L22:
                return new f(Operand.N, this.f525860c, this.f525861d, this.f525862e);
            }

            public final String toString() {
                StringBuilder r100 = new StringBuilder();
                r100.append(this.f525859b.name().toLowerCase(Locale.ROOT));
                if (this.f525860c == null) goto L5;
                r100.append(" % ");
                r100.append(this.f525860c.intValue());
            L5:
                r100.append(' ');
                if (this.f525861d == false) goto L8;
                r100.append('!');
            L8:
                r100.append("= ");
                IntRange[] r101 = this.f525862e;
                int r102 = r101.length;
                boolean r103 = true;
                int r104 = 0;
            L9:
                if (r104 >= r102) goto L18;
                IntRange r105 = r101[r104];
                if (r103 == true) goto L13;
                r100.append(',');
            L13:
                r100.append(r105.getFirst());
                if (r105.getFirst() == r105.getLast()) goto L16;
                r100.append(DownloadConstants.VULNERABILITY_PATH);
                r100.append(r105.getLast());
            L16:
                r104 = r104 + 1;
                r103 = false;
                goto L9
            L18:
                return r100.toString();
            }

            @Override // org.jetbrains.compose.resources.plural.PluralRule.Condition
            public final boolean a(Condition r100) {
                Intrinsics.checkNotNullParameter(r100, "other");
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof f) == true) goto L8;
                return false;
            L8:
                Operand r101 = this.f525859b;
                Operand r102 = Operand.N;
                if (r101 != r102) goto L11;
            L14:
                boolean r103 = true;
            L15:
                f r104 = (f) r100;
                Operand r105 = r104.f525859b;
                if (r105 != r102) goto L18;
            L21:
                boolean r106 = true;
            L22:
                if (r103 == r106) goto L25;
                return false;
            L25:
                if (Intrinsics.areEqual(this.f525860c, r104.f525860c) == true) goto L28;
                return false;
            L28:
                if (this.f525861d == r104.f525861d) goto L31;
                return false;
            L31:
                if (Arrays.equals(this.f525862e, r104.f525862e) == true) goto L33;
                return false;
            L33:
                return true;
            L18:
                if (r105 == Operand.I) goto L21;
                r106 = false;
                goto L22
            L11:
                if (r101 == Operand.I) goto L14;
                r103 = false;
                goto L15
            }

            public f(Operand r100, Integer r101, boolean r102, IntRange[] r103) {
                Intrinsics.checkNotNullParameter(r100, "operand");
                Intrinsics.checkNotNullParameter(r103, "ranges");
                this.f525859b = r100;
                this.f525860c = r101;
                this.f525861d = r102;
                this.f525862e = r103;
            }
        }

        public static final class g extends Condition {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g f525864b = null;

            static {
                f525864b = new g();
            }

            @Override // org.jetbrains.compose.resources.plural.PluralRule.Condition
            public final Condition b() {
                return this;
            }

            public final String toString() {
                return "";
            }

            public g() {
            }

            @Override // org.jetbrains.compose.resources.plural.PluralRule.Condition
            public final boolean a(Condition r100) {
                Intrinsics.checkNotNullParameter(r100, "other");
                return Intrinsics.areEqual(this, r100);
            }
        }

        static {
        }

        public Condition() {
        }

        public abstract boolean a(Condition r100);

        public abstract Condition b();
    }

    public PluralRule(PluralCategory r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "category");
        Intrinsics.checkNotNullParameter(r101, "condition");
        int r102 = Condition.f525849a;
        Intrinsics.checkNotNullParameter(r101, "description");
        Condition.e r103 = new Condition.e(r101);
        r103.d();
        boolean r104 = true;
        if (r103.f525858b < r103.f525857a.length()) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L8;
        Condition r106 = Condition.g.f525864b;
    L19:
        r106.b();
        return;
    L8:
        Condition r107 = r103.e();
    L9:
        r103.d();
        Character r108 = StringsKt.getOrNull(r103.f525857a, r103.f525858b);
        if (r108 == null) goto L14;
        if (r108.charValue() != 'o') goto L14;
        r103.b();
        if (r103.b() != 'r') goto L24;
        boolean r109 = true;
    L25:
        r103.a(r109);
        r107 = new Condition.d(r107, r103.e());
        goto L9
    L24:
        r109 = false;
    L14:
        r103.d();
        if (r103.f525858b >= r103.f525857a.length()) goto L18;
        r104 = false;
    L18:
        r103.a(r104);
        r106 = r107;
        goto L19
    L5:
        r105 = false;
        goto L6
    }
}
