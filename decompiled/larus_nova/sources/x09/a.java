package x09;

import android.os.Bundle;
import com.android.ttcjpaysdk.verify.constants.DyVerifyEventConstants;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class a implements t1a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f562050a;

    public a() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f562050a, ((a) r100).f562050a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Bundle r100 = this.f562050a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "FlowCommonVenueArgumentData(arguments=" + this.f562050a + ')';
    }

    public final String a() {
        Bundle r100 = this.f562050a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getString("action_bar_key");
    }

    public final Integer b() {
        Bundle r100 = this.f562050a;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.containsKey(DyVerifyEventConstants.EventParam.BIZ_SCENE) == true) goto L8;
        r100 = null;
    L8:
        if (r100 != null) goto L10;
        return null;
    L10:
        return Integer.valueOf(r100.getInt(DyVerifyEventConstants.EventParam.BIZ_SCENE));
    }

    public final String c() {
        Bundle r100 = this.f562050a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getString("enter_method");
    }

    public a(Bundle r100) {
        this.f562050a = r100;
    }

    public final List<d> d(String r100) {
        List r101 = StringsKt.split$default(r100, new String[]{"_"}, false, 0, 6, null);
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(StringsKt.trim((String) r103.next()).toString());
        goto L4
    L6:
        ArrayList r104 = new ArrayList();
        Iterator r105 = r102.iterator();
    L7:
        int r106 = 0;
        if (r105.hasNext() == false) goto L14;
        Object r107 = r105.next();
        if (((String) r107).length() <= 0) goto L12;
        r106 = 1;
    L12:
        if (r106 == 0) goto L7;
        r104.add(r107);
        goto L7
    L14:
        ArrayList r108 = new ArrayList();
        int r109 = ProgressionUtilKt.getProgressionLastElement(0, r104.size() - 1, 2);
        if (r109 < 0) goto L31;
    L16:
        int r110 = r106 + 1;
        if (r110 >= r104.size()) goto L31;
        String r111 = (String) ListProtector.get(r104, r106);
        String r112 = (String) ListProtector.get(r104, r110);
        Float r113 = StringsKt.toFloatOrNull(r111);
        if (r113 == null) goto L29;
        float r114 = r113.floatValue();
        if (r114 < 0.0f) goto L29;
        if (r114 > 1.0f) goto L29;
        String r115 = b.a(r112);
        if (r115 == null) goto L29;
        r108.add(new d(r115, r114));
    L29:
        if (r106 == r109) goto L31;
        r106 = r106 + 2;
    L31:
        return r108;
    }
}
