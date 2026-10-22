package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt;

import android.app.Application;
import androidx.lifecycle.FlowLiveDataConversions;
import com.larus.bmhome.bot.bean.ImageUploadResult;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.AIGenBgImageRepository;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.BotBgImageGenerateViewModel;
import com.larus.bot.impl.feature.edit.viewmodel.BotImageUploadViewModel;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes26.dex */
public final class BgPromptGenerateViewModel implements i, h {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f318713q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f318714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AIGenBgImageRepository f318715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f318716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BotImageUploadViewModel f318717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final StateFlowImpl f318718e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b1 f318719f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableSharedFlow<e> f318720g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a1 f318721h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Job f318722i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f318723j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f318724k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f318725l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageUploadResult f318726m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f318727n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f318728o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.h f318729p;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.h
    public final String a() {
        return this.f318716c.a();
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.h
    public final void b(g r100) {
        Intrinsics.checkNotNullParameter(r100, "doOnNext");
        this.f318716c.b(r100);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.h
    public final String c() {
        return this.f318716c.c();
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.h
    public final uc9.b d() {
        return this.f318716c.d();
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.h
    public final String e() {
        return this.f318716c.e();
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.h
    public final String f() {
        return this.f318716c.f();
    }

    @Override // uu8.b
    public final d1<e> getUiEvent() {
        return this.f318721h;
    }

    @Override // uu8.b
    public final i1<f> getUiState() {
        return this.f318719f;
    }

    @Override // uu8.b
    public final void dispatchUIAction(d r100) {
        d r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "uiAction");
        String r102 = "";
        ImageUploadResult r103 = null;
        if (Intrinsics.areEqual(r101, d.a.f318733a) == false) goto L33;
        int r104 = ((f) this.f318719f.getValue()).f318742c;
        if (r104 == 0) goto L17;
        if (r104 == 1) goto L9;
        if (r104 == 2) goto L9;
        return;
    L9:
        Job r105 = this.f318722i;
        if (r105 == null) goto L12;
        Job.DefaultImpls.cancel$default(r105, null, 1, null);
        this.f318722i = null;
    L12:
        h(new TextRes.StringResId(R.string.larus_describe_image_textBox), false, 0);
        uc9.b r106 = d();
        r106.f549658a = this.f318723j;
        String r107 = d().f549658a;
        if (r107 == null) goto L16;
        r102 = r107;
    L16:
        i(new e.a(r102));
        qu8.b.d("gen_prompt", -1);
        return;
    L17:
        String r108 = d().f549658a;
        if (r108 != null) goto L20;
        r108 = "";
    L20:
        this.f318723j = r108;
        i(new e.a(""));
        if (StringsKt.isBlank(this.f318723j) == false) goto L23;
        h(new TextRes.StringResId(R.string.larus_generate_desc_textBox), true, 1);
    L24:
        qu8.b.e("gen_prompt", "bot_create/bg_setting/ai", false);
        ImageUploadResult r109 = this.f318726m;
        if (r109 != null) goto L27;
    L31:
        b(new g(this));
        return;
    L27:
        if (this.f318727n == false) goto L29;
        r103 = r109;
    L29:
        if (r103 == null) goto L31;
        g(r103);
        return;
    L23:
        h(new TextRes.StringResId(R.string.larus_refine_description_textBox), true, 2);
        goto L24
    L33:
        if (Intrinsics.areEqual(r101, d.b.f318734a) == false) goto L42;
        this.f318726m = null;
        this.f318727n = true;
        if (((f) this.f318719f.getValue()).f318742c != 0) goto L40;
        String r110 = d().f549658a;
        if (r110 == null) goto L40;
        r102 = r110;
    L40:
        i(new e.b(r102));
        return;
    L42:
        if ((r101 instanceof d.C4129d) == false) goto L51;
        d().f549658a = ((d.C4129d) r101).f318736a;
        String r111 = d().f549658a;
        if (r111 == null) goto L47;
        r102 = r111;
    L47:
        i(new e.a(r102));
        if (this.f318725l == true) goto L60;
        FLogger.f375446a.d("BgPromptGenerateViewModel", "onTextChange, clear bgImgPromptEn");
        this.f318725l = true;
        d().f549659b = null;
        return;
    L60:
        return;
    L51:
        if (Intrinsics.areEqual(r101, d.c.f318735a) == false) goto L55;
        this.f318726m = null;
        this.f318727n = false;
        return;
    L55:
        throw new NoWhenBranchMatchedException();
    }

    public final void g(ImageUploadResult r100) {
        this.f318722i = BuildersKt.launch$default(this.f318714a, Dispatchers.getIO(), null, new BgPromptGenerateViewModel$generatePrompt$1(this, r100, null), 2, null);
    }

    public final void i(e r100) {
        BuildersKt.launch$default(this.f318714a, null, null, new BgPromptGenerateViewModel$sendUIEvent$1(this, r100, null), 3, null);
    }

    public final void h(TextRes.StringResId r100, boolean r101, @BgPromptEditState int r102) {
        StateFlowImpl r103 = this.f318718e;
        ((f) this.f318719f.getValue()).getClass();
        Intrinsics.checkNotNullParameter(r100, "hint");
        r103.setValue(new f(r100, r101, r102));
    }

    public BgPromptGenerateViewModel(Application r100, CoroutineScope r101, AIGenBgImageRepository r102, BotBgImageGenerateViewModel.b r103) {
        Intrinsics.checkNotNullParameter(r100, "application");
        Intrinsics.checkNotNullParameter(r101, "scope");
        Intrinsics.checkNotNullParameter(r102, "repo");
        Intrinsics.checkNotNullParameter(r103, "dependency");
        this.f318714a = r101;
        this.f318715b = r102;
        this.f318716c = r103;
        BotImageUploadViewModel r104 = new BotImageUploadViewModel(r100);
        this.f318717d = r104;
        StateFlowImpl r105 = j1.a(new f(new TextRes.StringResId(R.string.larus_describe_image_textBox), false, 0));
        this.f318718e = r105;
        this.f318719f = kotlinx.coroutines.flow.e.b(r105);
        MutableSharedFlow<e> r106 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.f318720g = r106;
        this.f318721h = kotlinx.coroutines.flow.e.a(r106);
        this.f318723j = "";
        this.f318724k = "";
        this.f318729p = new com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.h();
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(FlowLiveDataConversions.asFlow(r104.getUpload().f360128c), new BgPromptGenerateViewModel$bindObservers$1(this, null)), r101);
    }
}
