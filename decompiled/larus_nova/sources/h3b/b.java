package h3b;

import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.mapapi.http.HttpClient;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.i;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.n;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.blueprint.v;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.w;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.export.ui.message.style.BubbleStyle;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends BlueprintCell<y6b.a<?>> implements e6b.b<y6b.a<?>> {

    public static final class a {
    }

    /* JADX INFO: renamed from: h3b.b$b, reason: collision with other inner class name */
    public static final class C6099b implements wza.c<y6b.a<?>, com.ss.android.lark.blueprint.f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<com.ss.android.lark.blueprint.f> f483730a;

        public C6099b() {
            this.f483730a = com.ss.android.lark.blueprint.f.class;
        }

        public final Class<com.ss.android.lark.blueprint.f> b() {
            return this.f483730a;
        }

        @Override // wza.c
        public final m<y6b.a<?>> a(g r100, n r101) {
            com.ss.android.lark.blueprint.f r102 = (com.ss.android.lark.blueprint.f) r101;
            Intrinsics.checkNotNullParameter(r100, "ctx");
            Intrinsics.checkNotNullParameter(r102, "cellSpec");
            return new b(r100, r102);
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f483731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y6b.a<?> f483732b;

        public c(b r100, y6b.a<?> r101) {
            this.f483731a = r100;
            this.f483732b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            b r100 = this.f483731a;
            y6b.a<?> r101 = this.f483732b;
            if (DevEnvUtil.isDebugMode(r100.f410619a.getContext()) == false) goto L39;
            StringBuilder r102 = new StringBuilder();
            StringBuilder r103 = new StringBuilder("BlueprintCell - ");
            r103.append(r101.getType());
            r103.append(" / ");
            r103.append(r101.getType().getNumber());
            r103.append(" - ");
            r103.append(r101.getId());
            r103.append(" - ");
            r103.append(r101.A());
            r103.append(" - ");
            if ((r101 instanceof y6b.c) == false) goto L8;
            y6b.c r104 = (y6b.c) r101;
        L9:
            if (r104 == null) goto L11;
            Object r105 = Integer.valueOf(r104.W2);
        L12:
            r103.append(r105);
            r103.append('\n');
            r102.append(r103.toString());
            r102.append("  layout: " + r100.f410620b.a() + " - " + r100.l().getClass().getSimpleName() + '\n');
            r102.append("  blocks: [" + r100.f410620b.b().size() + "] " + CollectionsKt.joinToString$default(r100.f410620b.b(), ", ", null, null, 0, null, null, 62, null) + '\n');
            r102.append("  slots:\n");
            q<y6b.a<?>> r106 = r100.l();
            if ((r106 instanceof h3b.c) == false) goto L15;
            h3b.c r107 = (h3b.c) r106;
        L16:
            if (r107 == null) goto L38;
            Iterator<v> r108 = r107.g().iterator();
        L19:
            if (r108.hasNext() == false) goto L38;
            v r109 = r108.next();
            r102.append(LineContent.FOUR_SPACE + r109 + ": ");
            View r111 = r107.n(r109);
            if ((r111 instanceof ViewGroup) == false) goto L23;
            ViewGroup r112 = (ViewGroup) r111;
        L24:
            int r113 = 0;
            if (r112 == null) goto L34;
            int r114 = r112.getChildCount();
            int r115 = 0;
        L27:
            if (r113 >= r114) goto L33;
            j r116 = yza.a.a(r112.getChildAt(r113));
            if (r116 == null) goto L31;
            r102.append(r116 + ", ");
        L32:
            r113 = r113 + 1;
            r115 = 1;
            goto L27
        L31:
            r102.append("{View}, ");
            goto L32
        L33:
            r113 = r115;
        L34:
            if (r113 == 0) goto L36;
            r102.delete(r102.length() - 2, r102.length());
        L37:
            r102.append("\n");
            goto L19
        L36:
            r102.append(HttpClient.ENDFLAG);
            goto L37
        L23:
            r112 = null;
        L38:
            Log.d(r102.toString());
            goto L39
        L15:
            r107 = null;
            goto L16
        L11:
            r105 = "N/A";
            goto L12
        L8:
            r104 = null;
        L39:
            this.f483731a.m(this.f483732b);
        }
    }

    public static final class d implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f483733a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y6b.a<?> f483734b;

        public d(b r100, y6b.a<?> r101) {
            this.f483733a = r100;
            this.f483734b = r101;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            return this.f483733a.n(this.f483734b);
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f483735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y6b.a<?> f483736b;

        public e(b r100, y6b.a<?> r101) {
            this.f483735a = r100;
            this.f483736b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f483735a.m(this.f483736b);
        }
    }

    public static final class f implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f483737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y6b.a<?> f483738b;

        public f(b r100, y6b.a<?> r101) {
            this.f483737a = r100;
            this.f483738b = r101;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            return this.f483737a.n(this.f483738b);
        }
    }

    static {
    }

    @Override // com.ss.android.lark.blueprint.BlueprintCell
    public final int k(j r100) {
        Intrinsics.checkNotNullParameter(r100, "blockKey");
        Iterator<j> r101 = this.f410620b.b().iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L19;
        j r103 = r101.next();
        if (Intrinsics.areEqual(r103, r100) == true) goto L7;
        Intrinsics.checkNotNullParameter(r103, "blockKey");
        i r104 = (i) ((LinkedHashMap) this.f410622d).get(r103);
        if ((r104 instanceof e6b.a) == true) goto L10;
        r102 = r102 + 1;
        goto L4
    L10:
        e6b.a.C5748a r105 = ((e6b.a) r104).e(r100);
        int r106 = r105.f471155a;
        if (r106 >= 0) goto L13;
        if (Intrinsics.areEqual(r103, r100) == false) goto L17;
        Log.e("Fist block key must be found in sub order.");
    L17:
        r102 = r102 + r105.f471156b;
        goto L4
    L13:
        return r102 + r106;
    L7:
        return r102;
    L19:
        return -1;
    }

    public final void m(y6b.a<?> r100) {
        i3b.a r101 = (i3b.a) this.f410619a.f410652c.a(i3b.a.class);
        if (r101 == null) goto L6;
        r101.d(this, r100);
        return;
    }

    public final boolean n(y6b.a<?> r100) {
        q<y6b.a<?>> r101 = l();
        if ((r101 instanceof com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.g) == false) goto L5;
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.g r102 = (com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.g) r101;
    L6:
        if (r102 == null) goto L9;
        Point r103 = r102.i();
        if (r103 == null) goto L9;
    L10:
        i3b.a r104 = (i3b.a) this.f410619a.f410652c.a(i3b.a.class);
        if (r104 != null) goto L15;
        return false;
    L15:
        return r104.c(this, r100, r103);
    L9:
        r103 = new Point();
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public void update(y6b.a<?> r110) {
        Intrinsics.checkNotNullParameter(r110, "data");
        super.update(r110);
        boolean r100 = true;
        if (r110.getType() != Message.Type.UNKNOWN) goto L5;
    L10:
        boolean r101 = true;
    L11:
        View r102 = this.f410625g;
        if (r102 == null) goto L14;
        r102.setOnClickListener(new c(this, r110));
    L14:
        l3b.a r103 = null;
        if (r101 == true) goto L27;
        q<y6b.a<?>> r104 = l();
        if ((r104 instanceof com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.d) == false) goto L19;
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.d r105 = (com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.d) r104;
    L20:
        if (r105 == null) goto L27;
        View r106 = this.f410625g;
        if (r106 == null) goto L24;
        r106.setOnLongClickListener(new d(this, r110));
    L24:
        ViewGroup r107 = r105.k();
        if (r107 == null) goto L27;
        r107.setOnClickListener(new e(this, r110));
        r107.setOnLongClickListener(new f(this, r110));
        goto L27
    L19:
        r105 = null;
    L27:
        Iterator<T> r108 = this.f410620b.b().iterator();
    L29:
        if (r108.hasNext() == false) goto L37;
        j r109 = (j) r108.next();
        Intrinsics.checkNotNullParameter(r109, "blockKey");
        i r111 = (i) ((LinkedHashMap) this.f410622d).get(r109);
        if ((r111 instanceof e6b.d) == false) goto L33;
        e6b.d r112 = (e6b.d) r111;
    L34:
        if (r112 == null) goto L29;
        r112.d(this, l(), r110);
        goto L29
    L33:
        r112 = null;
        goto L34
    L37:
        i3b.d r113 = (i3b.d) this.f410619a.f410652c.a(i3b.d.class);
        if (r113 == null) goto L79;
        q<y6b.a<?>> r114 = l();
        if ((r114 instanceof l3b.a) == false) goto L42;
        r103 = (l3b.a) r114;
    L42:
        if (r103 == null) goto L46;
        BubbleStyle r115 = r103.p();
        if (r115 == null) goto L46;
        int r116 = r115.f415426f;
    L47:
        int r117 = h3b.a.f483729a;
        m2b.a r118 = r113.a();
        FragmentActivity r119 = r113.a().getContext();
        y6b.c r120 = (y6b.c) r110;
        Intrinsics.checkNotNullParameter(this, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r118, "chatContext");
        Intrinsics.checkNotNullParameter(r119, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r120, "data");
        if ((l() instanceof com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.a) == false) goto L79;
        View r121 = this.f410625g;
        if (r121 == null) goto L79;
        Drawable r122 = r121.getBackground();
        if (r122 != null) goto L56;
    L60:
        if (r122 != null) goto L62;
    L64:
        boolean r123 = false;
    L65:
        if (r123 == true) goto L79;
        jdb.g r124 = w.a(r118).C();
        if (r120.V1 == false) goto L70;
    L77:
        r121.setTag(R.id.reset_background, r121.getBackground());
        goto L79
    L70:
        if (com.ss.android.lark.chat.utils.i.a(r120, r124, r118.getChat()) == true) goto L77;
        if (Intrinsics.areEqual(r120.f566482c, r118.D8()) == false) goto L74;
        r121.setBackgroundColor(UIUtils.getColor(r119, R.color.imtoken_message_bg_pin));
        goto L77
    L74:
        if (r116 == 0) goto L76;
        r121.setBackground(UIUtils.getDrawable(r119, r116));
        goto L77
    L76:
        int r125 = p3b.a.W;
        StateListDrawable r126 = new StateListDrawable();
        ColorDrawable r127 = new ColorDrawable();
        r127.setColor(v4b.a.f553184v);
        ColorDrawable r128 = new ColorDrawable();
        r128.setColor(UIHelper.getColor(R.color.lkui_transparent));
        r126.addState(new int[]{android.R.attr.state_selected}, r127);
        r126.addState(new int[]{-16842913}, r128);
        r121.setBackground(r126);
        goto L77
    L62:
        if ((r122 instanceof g2b.g) == false) goto L64;
    L63:
        r123 = true;
        goto L65
    L56:
        if ((r122 instanceof ColorDrawable) == false) goto L60;
        if (((ColorDrawable) r122).getColor() != ContextCompat.getColor(r121.getContext(), R.color.ud_Y100)) goto L64;
    L46:
        r116 = 0;
    L79:
        if (TextUtils.isEmpty(r110.getId()) == true) goto L81;
    L83:
        r100 = false;
    L84:
        View r129 = this.f410625g;
        if (r129 == null) goto L91;
        if (r100 == false) goto L88;
        int r130 = 8;
    L89:
        r129.setVisibility(r130);
        goto L91
    L88:
        r130 = 0;
    L91:
        if (Intrinsics.areEqual(r110.getId(), "fake_id_in_target_preview_when_wallpaper_set") == false) goto L93;
    L99:
        View r131 = this.f410625g;
        if (r131 == null) goto L111;
        ViewGroup.LayoutParams r132 = r131.getLayoutParams();
        if (r132 == null) goto L112;
        r132.height = 0;
        return;
    L112:
        return;
    L111:
        return;
    L93:
        if (Intrinsics.areEqual(r110.getcId(), "fake_id_in_target_preview_when_wallpaper_set") == true) goto L99;
        if (Intrinsics.areEqual(r110.getChatId(), "fake_id_in_target_preview_when_wallpaper_set") == true) goto L99;
        if (Intrinsics.areEqual(r110.g(), "fake_id_in_target_preview_when_wallpaper_set") == true) goto L99;
        if (r100 == true) goto L99;
        return;
    L81:
        if (TextUtils.isEmpty(r110.getcId()) == false) goto L83;
    L5:
        if (this.f410620b.b().contains(IMMessageKeys$Blocks.UNKNOWN_CONTENT) == true) goto L10;
        if (this.f410620b.b().contains(IMMessageKeys$Blocks.FLOW_UNKNOWN_CONTENT) == true) goto L10;
        r101 = false;
        goto L11
    }

    @Override // com.ss.android.lark.blueprint.BlueprintCell, com.ss.android.lark.blueprint.m
    public /* bridge */ /* synthetic */ void update(Object r100) {
        update((y6b.a) r100);
    }

    public b(g r100, n r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r101, "cellSpec");
        super(r100, r101);
    }

    @Override // com.ss.android.lark.blueprint.BlueprintCell, com.ss.android.lark.blueprint.m
    public final void d(Object r100, List r101) {
        y6b.a r102 = (y6b.a) r100;
        Intrinsics.checkNotNullParameter(r102, "data");
        Intrinsics.checkNotNullParameter(r101, "patchData");
        super.d(r102, r101);
        Iterator<T> r103 = this.f410620b.b().iterator();
    L4:
        if (r103.hasNext() == false) goto L12;
        j r104 = (j) r103.next();
        Intrinsics.checkNotNullParameter(r104, "blockKey");
        i r105 = (i) ((LinkedHashMap) this.f410622d).get(r104);
        if ((r105 instanceof e6b.d) == false) goto L8;
        e6b.d r106 = (e6b.d) r105;
    L9:
        if (r106 == null) goto L4;
        r106.d(this, l(), r102);
        goto L4
    L8:
        r106 = null;
        goto L9
    }

    @Override // e6b.b
    public final boolean e(i r100, y6b.a<?> r101) {
        y6b.a<?> r102 = r101;
        Intrinsics.checkNotNullParameter(r100, "block");
        Intrinsics.checkNotNullParameter(r102, "data");
        return n(r102);
    }

    @Override // e6b.b
    public final void f(i r100, y6b.a<?> r101) {
        y6b.a<?> r102 = r101;
        Intrinsics.checkNotNullParameter(r100, "block");
        Intrinsics.checkNotNullParameter(r102, "data");
        q<y6b.a<?>> r103 = l();
        if ((r103 instanceof com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.g) == false) goto L5;
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.g r104 = (com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.g) r103;
    L6:
        if (r104 == null) goto L9;
        Point r105 = r104.i();
        if (r105 == null) goto L9;
    L10:
        i3b.a r106 = (i3b.a) this.f410619a.f410652c.a(i3b.a.class);
        if (r106 == null) goto L14;
        r106.h(this, r102, r105);
        return;
    L14:
        return;
    L9:
        r105 = new Point();
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    @Override // e6b.b
    public final void j(i r100, y6b.a<?> r101) {
        y6b.a<?> r102 = r101;
        Intrinsics.checkNotNullParameter(r100, "block");
        Intrinsics.checkNotNullParameter(r102, "data");
        m(r102);
    }
}
