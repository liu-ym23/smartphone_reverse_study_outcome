package ik6;

import ak6.f;
import ak6.g;
import android.text.SpannableString;
import android.text.style.CharacterStyle;
import android.text.style.ReplacementSpan;
import com.bytedance.live.richcontent.ResourceInfo;
import ek6.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f490269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f490270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SpannableString f490271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<ek6.d, ak6.c> f490272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<ResourceInfo> f490273e;

    public final g c() {
        SpannableString r100 = this.f490271c;
        if (r100 != null) goto L7;
        r100 = new SpannableString("");
    L7:
        return new g(r100, e(), this.f490269a, this.f490272d, this.f490273e);
    }

    public final List<ResourceInfo> d() {
        List<ResourceInfo> r100 = this.f490273e;
        if (r100 == null) goto L13;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L20;
        Object r103 = r102.next();
        if (((ResourceInfo) r103).f255742c != ResourceInfo.State.READY) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L6;
        r101.add(r103);
        goto L6
    L10:
        r104 = false;
        goto L11
    L20:
        return r101;
    L13:
        return null;
    }

    public final boolean e() {
        List<ResourceInfo> r100 = this.f490273e;
        Object r101 = null;
        if (r100 == null) goto L14;
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L13;
        Object r103 = r102.next();
        if (((ResourceInfo) r103).f255742c != ResourceInfo.State.READY) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L6;
        r101 = r103;
        goto L13
    L10:
        r104 = false;
    L13:
        r101 = (ResourceInfo) r101;
    L14:
        if (r101 == null) goto L23;
        return false;
    L23:
        return true;
    }

    public d(g r100, com.bytedance.android.livesdk.interactivity.service.richcontent.config.b r101) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        Intrinsics.checkNotNullParameter(r101, "config");
        this.f490269a = r100.f4076c;
        this.f490270b = r101;
        Map<ek6.d, ak6.c> r102 = r100.f4077d;
        List<ResourceInfo> r103 = null;
        if (r102 == null) goto L5;
        Map<ek6.d, ak6.c> r104 = MapsKt.toMutableMap(r102);
    L6:
        this.f490272d = r104;
        List<ResourceInfo> r105 = r100.f4078e;
        if (r105 == null) goto L9;
        r103 = CollectionsKt.toMutableList(r105);
    L9:
        this.f490273e = r103;
        if (r101.f4073b == false) goto L12;
        SpannableString r106 = new SpannableString(r100.f4074a);
    L13:
        this.f490271c = r106;
        return;
    L12:
        r106 = r100.f4074a;
        goto L13
    L5:
        r104 = null;
        goto L6
    }

    @Override // ik6.b
    public final void a(ek6.d r100, CharacterStyle r101) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, "span");
        SpannableString r102 = this.f490271c;
        if (r102 == null) goto L10;
        Map<ek6.d, ak6.c> r103 = this.f490272d;
        if (r103 == null) goto L11;
        ak6.c r104 = r103.get(r100);
        if (r104 == null) goto L12;
        r102.setSpan(r101, r104.f4069a, r104.f4070b, 33);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // ik6.b
    public final void b(ek6.d r100, ReplacementSpan r101) {
        Intrinsics.checkNotNullParameter(r100, "content");
        SpannableString r102 = this.f490271c;
        if (r102 == null) goto L21;
        Map<ek6.d, ak6.c> r103 = this.f490272d;
        if (r103 == null) goto L22;
        ak6.c r104 = r103.get(r100);
        if (r104 == null) goto L23;
        int r105 = r104.f4069a;
        int r106 = r104.f4070b;
        ReplacementSpan[] r107 = (ReplacementSpan[]) r102.getSpans(r105, r106, ReplacementSpan.class);
        int r108 = 0;
        if (r107.length != 0) goto L11;
        boolean r109 = true;
    L13:
        if ((!r109) == false) goto L17;
        int r110 = r107.length;
    L15:
        if (r108 >= r110) goto L17;
        r102.removeSpan(r107[r108]);
        r108 = r108 + 1;
    L17:
        if (r101 == null) goto L24;
        r102.setSpan(r101, r105, r106, 33);
        return;
    L24:
        return;
    L11:
        r109 = false;
        goto L13
    L23:
        return;
    L22:
        return;
    }

    public d(e r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "richContent");
        Intrinsics.checkNotNullParameter(r101, "config");
        this.f490269a = r100;
        this.f490270b = r101;
    }
}
