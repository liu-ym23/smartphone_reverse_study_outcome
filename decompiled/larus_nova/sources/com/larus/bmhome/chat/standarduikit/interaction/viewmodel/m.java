package com.larus.bmhome.chat.standarduikit.interaction.viewmodel;

import com.larus.im.bean.message.block.QuickReplyItem;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f309376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f309377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f309378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<QuickReplyItem> f309379d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f309380e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f309381f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f309382g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f309383h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.larus.bmhome.taskskill.service.l f309384i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e f309385j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f309386k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f309387l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f309388m;

    public static final class a {
    }

    public static final class b implements sl8.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f309389a;

        public final void b() {
            m r100 = this.f309389a;
            r100.f309386k = true;
            r100.f309385j.d();
            m r101 = this.f309389a;
            f r102 = r101.f309377b;
            if (r102 != null) goto L5;
            return;
        L5:
            g r103 = r101.f309378c;
            if (r103 == null) goto L9;
            r103.b(r102);
            return;
        }

        public b(m r100) {
            this.f309389a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v5, types: [com.larus.bmhome.chat.standarduikit.interaction.viewmodel.k] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // sl8.b
        public final void a(final int r110) {
            final m r100 = this.f309389a;
            if (r100.f309382g == true) goto L7;
            if (r100.f309381f == true) goto L7;
        L9:
            f r101 = r100.f309377b;
            if (r101 != null) goto L12;
            FLogger.f375446a.w("InteractionQuickReplyVM", "[click] missing vmData, visibleIndex=" + r110);
            return;
        L12:
            g r102 = r100.f309378c;
            if (r102 != 0) goto L15;
            FLogger.f375446a.w("InteractionQuickReplyVM", "[click] missing dependency, visibleIndex=" + r110);
            return;
        L15:
            QuickReplyItem r103 = (QuickReplyItem) CollectionsKt.getOrNull(r100.f309379d, r110);
            if (r103 != null) goto L18;
            FLogger.f375446a.w("InteractionQuickReplyVM", "[click] invalid visibleIndex=" + r110 + ", itemCount=" + r100.f309379d.size());
            return;
        L18:
            final int r104 = r100.f309383h;
            r100.f309387l = r103.getActionType();
            e r105 = r100.f309385j;
            Integer r106 = r103.getActionType();
            e.b r107 = r105.f309338d;
            if (r107 == null) goto L23;
            if (r106 == null) goto L23;
            int r108 = r106.intValue();
            Function2<String, JSONObject, Unit> r109 = r105.f309337c;
            JSONObject r111 = e.a(r107, true);
            r111.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r108);
            Unit r112 = Unit.INSTANCE;
            r109.invoke("click_interaction_button", r111);
        L23:
            FLogger.f375446a.i("InteractionQuickReplyVM", "[click] accepted, actionType=" + r103.getActionType() + ", visibleIndex=" + r110 + ", bindingVersion=" + r104);
            com.larus.bmhome.taskskill.service.l r113 = r100.f309384i;
            if (r113 == null) goto L26;
            r113.dispose();
        L26:
            r100.f309381f = true;
            r100.f309380e = Integer.valueOf(r110);
            r100.f309376a.invoke();
            r100.f309384i = r102.a(r101, r103, r110, new k(r100, r104, r110));
            return;
        L7:
            if (r100.f309380e == null) goto L9;
            FLogger.f375446a.d("InteractionQuickReplyVM", "[click] ignored, visibleIndex=" + r110 + ", bindingVersion=" + r100.f309383h + ", finished=" + r100.f309382g + ", actionInFlight=" + r100.f309381f);
        }
    }

    static {
    }

    public m(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "invalidate");
        this.f309376a = r100;
        this.f309379d = CollectionsKt.emptyList();
        this.f309385j = new e(0);
        this.f309388m = new b(this);
    }
}
