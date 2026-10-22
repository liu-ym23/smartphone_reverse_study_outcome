package com.ss.android.ainote.util;

import com.ss.android.ainote.j;
import com.ss.android.ainote.model.AINoteContentState;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import xra.b;

/* JADX INFO: loaded from: classes34.dex */
public final class AINoteCompareUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f407215a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RichText f407216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<b> f407217b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<String> f407218c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AINoteContentState f407219d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f407216a, r101.f407216a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f407217b, r101.f407217b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f407218c, r101.f407218c) == true) goto L18;
            return false;
        L18:
            if (this.f407219d == r101.f407219d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            RichText r100 = this.f407216a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L7:
            return (((((r101 * 31) + this.f407217b.hashCode()) * 31) + this.f407218c.hashCode()) * 31) + this.f407219d.hashCode();
        L5:
            r101 = r100.hashCode();
            goto L7
        }

        public final String toString() {
            return "NoteContentSnapshot(inputRichText=" + this.f407216a + ", images=" + this.f407217b + ", deletedImageIds=" + this.f407218c + ", contentState=" + this.f407219d + ')';
        }

        public a(RichText r100, List<b> r101, List<String> r102, AINoteContentState r103) {
            Intrinsics.checkNotNullParameter(r101, "images");
            Intrinsics.checkNotNullParameter(r102, "deletedImageIds");
            Intrinsics.checkNotNullParameter(r103, "contentState");
            this.f407216a = r100;
            this.f407217b = r101;
            this.f407218c = r102;
            this.f407219d = r103;
        }
    }

    static {
    }

    public static List b(List r110) {
        List r111 = r110;
        ArrayList r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator r112 = r111.iterator();
    L4:
        if (r112.hasNext() == false) goto L13;
        b r101 = (b) r112.next();
        String[] r102 = new String[4];
        r102[0] = r101.f564919a;
        String r103 = r101.f564922d;
        String r104 = "";
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        r102[1] = r103;
        String r105 = r101.f564923e;
        if (r105 == null) goto L12;
        r104 = r105;
    L12:
        r102[2] = r104;
        r102[3] = r101.f564926h.name();
        r100.add(CollectionsKt.joinToString$default(CollectionsKt.listOf(r102), "#", null, null, 0, null, null, 62, null));
        goto L4
    L13:
        return r100;
    }

    public static List c(List r100) {
        return SequencesKt.toList(SequencesKt.sorted(SequencesKt.distinct(SequencesKt.filter(CollectionsKt.asSequence(r100), AINoteCompareUtils$normalizedDeletedImageIds$1.INSTANCE))));
    }

    @JvmStatic
    public static final boolean a(j.g r100, RichText r101, boolean r102, long r103) {
        if (r100 == null) goto L14;
        if (r101 != null) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(r100.f406825f, r101) == true) goto L9;
        return false;
    L9:
        if (r100.f406827h == r102) goto L11;
        return false;
    L11:
        if (r100.f406824e != r103) goto L17;
        return true;
    L17:
        return false;
    L14:
        return false;
    }
}
