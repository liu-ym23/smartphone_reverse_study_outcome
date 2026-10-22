package com.larus.bmhome.chat.nestedmenu.provider.officetask;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.style.ReplacementSpan;
import androidx.core.content.ContextCompat;
import bs8.e;
import com.larus.bmhome.actionbar.model.AgentMode;
import com.larus.bmhome.actionbar.model.b2;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.t0;
import com.larus.bmhome.chat.nestedmenu.NestedMenuRightModel;
import com.larus.bmhome.chat.nestedmenu.NestedMenuScene;
import com.larus.bmhome.chat.nestedmenu.ui.q;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.bmhome.taskskill.service.TaskModeService;
import com.larus.bmhome.taskskill.service.d;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.larus.platform.service.p1;
import di8.b0;
import di8.c0;
import di8.d0;
import di8.f0;
import di8.g0;
import di8.o0;
import di8.p0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import v19.c7;
import v19.h;

/* JADX INFO: loaded from: classes25.dex */
public final class OfficeTaskNestedMenuProvider implements ei8.c, ei8.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f308263f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f308264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f308265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Job f308266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f308267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f308268e;

    public static final class a {
    }

    public static final class b extends ReplacementSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f308269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f308270b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f308271c;

        public b(int r100, int r101, int r102) {
            this.f308269a = r100;
            this.f308270b = r101;
            this.f308271c = r102;
        }

        @Override // android.text.style.ReplacementSpan
        public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
            Intrinsics.checkNotNullParameter(r100, "paint");
            return this.f308270b + (this.f308271c * 2);
        }

        @Override // android.text.style.ReplacementSpan
        public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            Intrinsics.checkNotNullParameter(r108, "paint");
            int r109 = r108.getColor();
            r108.setColor(this.f308269a);
            float r110 = this.f308270b / 2.0f;
            r100.drawCircle((r104 + this.f308271c) + r110, (r105 + r107) / 2.0f, r110, r108);
            r108.setColor(r109);
        }
    }

    static {
    }

    @Override // ei8.c
    public final String getKey() {
        return "office_task";
    }

    public final d g() {
        return (d) this.f308264a.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.bmhome.chat.nestedmenu.provider.officetask.c] */
    public OfficeTaskNestedMenuProvider() {
        this.f308264a = LazyKt.lazy(new com.larus.bmhome.chat.nestedmenu.provider.officetask.b());
        this.f308265b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.f308268e = new c(this);
    }

    public static String i(d0 r100) {
        f0 r101 = r100.c();
        String r102 = null;
        if ((r101 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L5;
        com.larus.bmhome.chat.nestedmenu.b r103 = (com.larus.bmhome.chat.nestedmenu.b) r101;
    L6:
        if (r103 == null) goto L18;
        com.larus.bmhome.chat.nestedmenu.b.a r104 = r103.f308231c;
        if (r104 == null) goto L18;
        t0 r105 = r104.f308233a;
        if (r105 == null) goto L18;
        String r106 = r105.f295451b;
        if (r106 == null) goto L18;
        if ((!StringsKt.isBlank(r106)) == false) goto L16;
        r102 = r106;
    L16:
        if (r102 == null) goto L18;
        return r102;
    L18:
        String r107 = r100.getCenter().f468753a;
        if (r107 != null) goto L22;
        return "";
    L22:
        return r107;
    L5:
        r103 = null;
        goto L6
    }

    public static String h(Context r100, int r101) {
        return "res://" + r100.getPackageName() + '/' + r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r15v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v8 */
    @Override // ei8.a
    public final LinkedHashMap<String, List<d0>> a(LinkedHashMap<String, List<d0>> r510, c0 r511) {
        Intrinsics.checkNotNullParameter(r510, "models");
        Intrinsics.checkNotNullParameter(r511, "config");
        if (r511.f468768a != NestedMenuScene.ACTION_BAR) goto L7;
        if (r511.f468774g.f468809a == true) goto L7;
    L8:
        boolean r100 = true;
    L10:
        if (r100 == true) goto L12;
        return r510;
    L12:
        boolean r110 = TaskModeService.f314424a.a();
        if (r110 == false) goto L15;
    L17:
        if (r110 == false) goto L22;
        e r101 = g().b();
        if (r101 != null) goto L21;
        r101 = this.f308267d;
    L21:
        e r102 = r101;
    L23:
        this.f308267d = r102;
        if (r102 == null) goto L26;
        List<PcDevice> r103 = r102.a();
    L27:
        if (r103 != null) goto L29;
        r103 = CollectionsKt.emptyList();
    L29:
        List<PcDevice> r111 = r103;
        String r104 = "mode";
        List<d0> r105 = r510.get("mode");
        if (r105 != null) goto L32;
        r105 = CollectionsKt.emptyList();
    L32:
        List<d0> r106 = r105;
        if ((r106 instanceof Collection) == true) goto L35;
    L37:
        Iterator r107 = r106.iterator();
    L39:
        if (r107.hasNext() == false) goto L58;
        f0 r108 = ((d0) r107.next()).c();
        if ((r108 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L43;
        com.larus.bmhome.chat.nestedmenu.b r109 = (com.larus.bmhome.chat.nestedmenu.b) r108;
    L44:
        if (r109 == null) goto L55;
        com.larus.bmhome.chat.nestedmenu.b.a r112 = r109.f308231c;
        if (r112 == null) goto L55;
        t0 r113 = r112.f308233a;
        if (r113 == null) goto L55;
        Integer r114 = r113.f295459j;
        int r115 = AgentMode.MOA.getValue();
        if (r114 == null) goto L55;
        if (r114.intValue() != r115) goto L55;
        boolean r116 = true;
    L56:
        if (r116 == false) goto L39;
        boolean r117 = true;
    L59:
        if (r117 == true) goto L62;
        r104 = DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL;
    L62:
        String r118 = r104;
        List<d0> r119 = r510.get(r118);
        if (r119 != null) goto L65;
        r119 = CollectionsKt.emptyList();
    L65:
        List<d0> r120 = r119;
        Iterator r121 = r120.iterator();
    L67:
        if (r121.hasNext() == false) goto L112;
        Object r122 = r121.next();
        f0 r123 = ((d0) r122).c();
        if ((r123 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L71;
        com.larus.bmhome.chat.nestedmenu.b r124 = (com.larus.bmhome.chat.nestedmenu.b) r123;
    L72:
        if (r124 == null) goto L83;
        com.larus.bmhome.chat.nestedmenu.b.a r125 = r124.f308231c;
        if (r125 == null) goto L83;
        t0 r126 = r125.f308233a;
        if (r126 == null) goto L83;
        Integer r127 = r126.f295459j;
        int r128 = AgentMode.MOA.getValue();
        if (r127 == null) goto L83;
        if (r127.intValue() != r128) goto L83;
        boolean r129 = true;
    L84:
        if (r129 == true) goto L109;
        if (r124 == null) goto L96;
        com.larus.bmhome.chat.nestedmenu.b.C4065b r130 = r124.f308229a;
        if (r130 == null) goto L96;
        b2 r131 = r130.f308234a;
        if (r131 == null) goto L96;
        Integer r132 = r131.f295005l;
        int r133 = AgentMode.MOA.getValue();
        if (r132 == null) goto L96;
        if (r132.intValue() != r133) goto L96;
        boolean r134 = true;
    L97:
        if (r134 == true) goto L109;
        if (r124 == null) goto L104;
        com.larus.bmhome.chat.nestedmenu.b.C4065b r135 = r124.f308229a;
        if (r135 == null) goto L104;
        b2 r136 = r135.f308234a;
        if (r136 == null) goto L104;
        String r137 = r136.f295012s;
    L106:
        if (Intrinsics.areEqual(r137, "3") == true) goto L109;
        boolean r138 = false;
    L110:
        if (r138 == false) goto L67;
    L113:
        d0 r139 = (d0) r122;
        if (r139 != null) goto L116;
        return r510;
    L116:
        Context r140 = r511.f468770c.getContext();
        String r141 = i(r139);
        Intrinsics.checkNotNull(r140);
        String r142 = h(r140, R.drawable.larus_ic_runtime_local_computer);
        String r210 = h(r140, R.drawable.larus_ic_runtime_cloud_computer);
        f0 r143 = r139.c();
        if ((r143 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L119;
        com.larus.bmhome.chat.nestedmenu.b r144 = (com.larus.bmhome.chat.nestedmenu.b) r143;
    L120:
        if (r144 == null) goto L124;
        com.larus.bmhome.chat.nestedmenu.b.a r145 = r144.f308231c;
        if (r145 == null) goto L124;
        t0 r146 = r145.f308233a;
    L125:
        boolean r147 = h.f552477a;
        if (h.b(r140) == false) goto L136;
        if (r146 == null) goto L132;
        g1 r148 = r146.f295455f;
        if (r148 == null) goto L132;
        String r149 = r148.f295156b;
        if (r149 == null) goto L132;
    L140:
        String r211 = r149;
    L142:
        o0 r150 = r511.f468774g;
        if (r150.f468809a == true) goto L145;
    L148:
        boolean r151 = true;
    L150:
        if (r102 == null) goto L158;
        List<PcDevice> r152 = r102.f20303a;
        if (r152 == null) goto L158;
        List<PcDevice> r153 = r152;
        ArrayList r154 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r153, 10));
        Iterator r155 = r153.iterator();
        ArrayList r156 = r154;
    L155:
        if (r155.hasNext() == false) goto L157;
        ArrayList r157 = r156;
        boolean r310 = r151;
        r157.add(j(this, (PcDevice) r155.next(), r140, r139.c(), r141, true, r111.size(), r142, r310));
        r156 = r157;
        r102 = r102;
        r151 = r310;
        r140 = r140;
        r139 = r139;
        r118 = r118;
        goto L155
    L157:
        boolean r311 = r151;
        Context r312 = r140;
        d0 r313 = r139;
        String r314 = r118;
        e r158 = r102;
        List r159 = r156;
    L159:
        if (r159 != null) goto L161;
        r159 = CollectionsKt.emptyList();
    L161:
        List r160 = r159;
        if (r158 == null) goto L169;
        List<PcDevice> r161 = r158.f20304b;
        if (r161 == null) goto L169;
        List<PcDevice> r162 = r161;
        ?? r163 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r162, 10));
        Iterator r212 = r162.iterator();
    L167:
        if (r212.hasNext() == false) goto L170;
        r163.add(j(this, (PcDevice) r212.next(), r312, r313.c(), r141, false, r111.size(), r142, r311));
    L170:
        if (r163 != 0) goto L172;
        r163 = CollectionsKt.emptyList();
    L172:
        Context r164 = r312;
        String r165 = r164.getString(R.string.larus_new_model_menu_mode_task_add_local_cn);
        if (r110 == false) goto L188;
        if (r158 == null) goto L176;
        List<PcDevice> r166 = r158.a();
    L177:
        List<PcDevice> r167 = r166;
        if (r167 != null) goto L180;
    L183:
        boolean r168 = true;
    L184:
        if (r168 == false) goto L188;
        if (p1.f365785a.g() == false) goto L188;
        String r169 = r141;
        com.larus.bmhome.chat.nestedmenu.d r170 = new com.larus.bmhome.chat.nestedmenu.d(new g0(Integer.valueOf(R.drawable.larus_ic_local_computer), null, null, false, null, 62), new b0(null, f(r164, r169, r165, false, true), null, null, null, null, null, null, null, null, 32764), null, false, null, false, null, new p0(r313.c(), false, null, null, null, null, true, 62), false, false, false, 1916);
    L189:
        ArrayList r171 = new ArrayList();
        Iterator r172 = r120.iterator();
    L191:
        if (r172.hasNext() == false) goto L212;
        d0 r173 = (d0) r172.next();
        d0 r174 = r313;
        if (r173 == r174) goto L195;
        boolean r175 = r311;
        List r176 = CollectionsKt.listOf(r173);
    L211:
        CollectionsKt.addAll(r171, r176);
        r313 = r174;
        r311 = r175;
        goto L191
    L195:
        if (r511.f468774g.f468812d == false) goto L197;
    L208:
        r175 = r311;
        d0 r177 = new com.larus.bmhome.chat.nestedmenu.d(new g0(Integer.valueOf(R.drawable.larus_ic_drive_page_menu_not_use_computer), null, null, false, null, 62), new b0(null, f(r164, r169, r164.getString(R.string.larus_office_task_runtime_cloud_computer_cn), true, r175), null, null, null, null, null, null, null, null, 32764), null, false, null, false, null, new p0(r174.c(), true, null, r164.getString(R.string.larus_office_task_runtime_cloud_computer_cn), r169, r210, false, 64), false, false, false, 1916);
    L209:
        r176 = CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(r160, CollectionsKt.listOfNotNull(r170)), r177), (Iterable) r163);
        goto L211
    L197:
        if ((!r111.isEmpty()) == true) goto L208;
        if (r170 != null) goto L208;
        if ((r174 instanceof com.larus.bmhome.chat.nestedmenu.d) == false) goto L203;
        com.larus.bmhome.chat.nestedmenu.d r178 = (com.larus.bmhome.chat.nestedmenu.d) r174;
    L204:
        if (r178 == null) goto L206;
        r177 = com.larus.bmhome.chat.nestedmenu.d.e(r178, new p0(((com.larus.bmhome.chat.nestedmenu.d) r174).f308254h, false, null, r169, r169, r211, false, 64));
    L207:
        r175 = r311;
        goto L209
    L206:
        r177 = r174;
        goto L207
    L203:
        r178 = null;
        goto L204
    L212:
        r510.put(r314, r171);
        return r510;
    L180:
        if (r167.isEmpty() == true) goto L183;
        r168 = false;
        goto L184
    L176:
        r166 = null;
    L188:
        r169 = r141;
        r170 = null;
    L169:
        r163 = 0;
    L158:
        r311 = r151;
        r312 = r140;
        r313 = r139;
        r314 = r118;
        r158 = r102;
        r159 = null;
        goto L159
    L145:
        if (r150.f468812d == true) goto L148;
        r151 = false;
    L132:
        if (r146 == null) goto L141;
        g1 r179 = r146.f295454e;
        if (r179 == null) goto L141;
        r149 = r179.f295156b;
    L141:
        r211 = null;
        goto L142
    L136:
        if (r146 == null) goto L141;
        g1 r180 = r146.f295454e;
        if (r180 == null) goto L141;
        r149 = r180.f295156b;
    L124:
        r146 = null;
        goto L125
    L119:
        r144 = null;
    L104:
        r137 = null;
    L96:
        r134 = false;
    L109:
        r138 = true;
    L83:
        r129 = false;
        goto L84
    L71:
        r124 = null;
        goto L72
    L112:
        r122 = null;
    L55:
        r116 = false;
        goto L56
    L43:
        r109 = null;
    L58:
        r117 = false;
        goto L59
    L35:
        if (r106.isEmpty() == false) goto L37;
    L26:
        r103 = null;
        goto L27
    L22:
        r102 = null;
        goto L23
    L15:
        if (r511.f468774g.f468812d == true) goto L17;
        return r510;
    L7:
        if (r511.f468774g.f468812d == true) goto L8;
        r100 = false;
        goto L10
    }

    @Override // ei8.b
    public final void b(LinkedHashMap<String, List<d0>> r100, c0 r101) {
        Intrinsics.checkNotNullParameter(r100, "models");
        Intrinsics.checkNotNullParameter(r101, "config");
        o0 r102 = r101.f468774g;
        if (r102.f468809a == false) goto L8;
        if (r102.f468812d == true) goto L8;
        return;
    L8:
        if (TaskModeService.f314424a.a() == true) goto L10;
        return;
    L10:
        g().f();
        g().d().observeForever(this.f308268e);
        Job r103 = this.f308266c;
        if (r103 == null) goto L13;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L13:
        this.f308266c = BuildersKt.launch$default(this.f308265b, null, null, new OfficeTaskNestedMenuProvider$onShow$1(this, null), 3, null);
    }

    @Override // ei8.b
    public final void c(List<? extends q> r100, c0 r101) {
        Intrinsics.checkNotNullParameter(r100, "nodes");
        Intrinsics.checkNotNullParameter(r101, "config");
    }

    @Override // ei8.b
    public final void d(LinkedHashMap<String, List<d0>> r100, c0 r101) {
        Intrinsics.checkNotNullParameter(r100, "models");
        Intrinsics.checkNotNullParameter(r101, "config");
    }

    @Override // ei8.b
    public final void e(LinkedHashMap<String, List<d0>> r100, c0 r101) {
        Intrinsics.checkNotNullParameter(r100, "models");
        Intrinsics.checkNotNullParameter(r101, "config");
        o0 r102 = r101.f468774g;
        if (r102.f468809a == true) goto L5;
    L7:
        Job r103 = this.f308266c;
        if (r103 == null) goto L10;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L10:
        this.f308266c = null;
        g().d().removeObserver(this.f308268e);
        g().e();
        return;
    L5:
        if (r102.f468812d == true) goto L7;
    }

    public static CharSequence f(Context r100, String r101, String r102, boolean r103, boolean r104) {
        if (r104 == false) goto L4;
        if (r103 == false) goto L7;
        int r105 = R.color.success_50;
    L9:
        return new SpannableStringBuilder(r101).append("￼", new b(ContextCompat.getColor(r100, r105), c7.b(6), c7.b(6)), 33).append(r102);
    L7:
        r105 = R.color.larus_neutral_50;
        goto L9
    L4:
        return r101 + ' ' + r102;
    }

    public static com.larus.bmhome.chat.nestedmenu.d j(OfficeTaskNestedMenuProvider r410, PcDevice r411, Context r412, f0 r413, String r414, boolean r415, int r416, String r510, boolean r511) {
        r410.getClass();
        String r100 = r411.d();
        boolean r110 = true;
        if (r100 != null) goto L5;
    L9:
        r100 = r411.getDeviceId();
        if (r100 != null) goto L12;
        r100 = "";
    L12:
        String r101 = r100;
        g0 r111 = new g0(Integer.valueOf(R.drawable.larus_ic_local_computer), null, null, false, null, 62);
        CharSequence r210 = f(r412, r414, r101, r415, r511);
        String r102 = r411.b();
        if (r102 != null) goto L15;
    L18:
        boolean r103 = true;
    L19:
        if (r103 == true) goto L36;
        List<String> r104 = p1.f365785a.k();
        if (r104 != null) goto L23;
    L25:
        boolean r105 = false;
    L26:
        if (r105 == false) goto L36;
        boolean r106 = h.f552477a;
        if (h.b(r412) == false) goto L31;
        String r107 = r411.i();
    L32:
        if (r107 == null) goto L36;
        if ((!StringsKt.isBlank(r107)) == false) goto L36;
        String r211 = r107;
    L37:
        b0 r112 = new b0(null, r210, r211, null, null, null, null, null, null, null, 32760);
        NestedMenuRightModel r113 = new NestedMenuRightModel(null, null, null, null, 1023);
        if (r416 != 1) goto L40;
        String r108 = r414;
    L41:
        p0 r212 = new p0(r413, false, r411, r101, r108, r510, false, 64);
        if (r415 == true) goto L48;
        if (Intrinsics.areEqual(qa9.a.a().a(), "1") == true) goto L48;
        r110 = false;
    L48:
        return new com.larus.bmhome.chat.nestedmenu.d(r111, r112, r113, false, null, false, null, r212, r110, false, false, 1656);
    L40:
        r108 = r101;
        goto L41
    L31:
        r107 = r411.h();
        goto L32
    L23:
        if (r104.contains(r411.b()) != true) goto L25;
        r105 = true;
    L36:
        r211 = null;
        goto L37
    L15:
        if (StringsKt.isBlank(r102) == true) goto L18;
        r103 = false;
        goto L19
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 != null) goto L12;
        goto L9
    }
}
