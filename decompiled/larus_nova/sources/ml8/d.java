package ml8;

import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.chat.block.base.config.ToolBlockInitStatus;
import com.larus.bmhome.chat.block.base.config.ToolBlockInteractType;
import com.larus.bmhome.chat.standarduikit.browsercontrol.view.BrowserControlView;
import com.larus.bmhome.chat.standarduikit.browsercontrol.view.ButtonStatus;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.DisplayHeader;
import com.larus.im.bean.message.block.GUIToolBlock;
import com.larus.utils.o0;
import jc8.e;
import kc8.w0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d extends jc8.b<ml8.a> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ll8.b f514375d;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f514376a = null;

        static {
            int[] r100 = new int[ToolBlockInitStatus.values().length];
            r100[ToolBlockInitStatus.Fold.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ToolBlockInitStatus.Expand.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ToolBlockInitStatus.Default.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f514376a = r100;
        }
    }

    @Override // jc8.b
    public final String c() {
        return "GuiToolBlockHolder";
    }

    public d() {
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r100) {
        ml8.a r101 = (ml8.a) r100;
        Intrinsics.checkNotNullParameter(r101, "blockModel");
        return e.d(r101);
    }

    @Override // jc8.b
    public final /* bridge */ /* synthetic */ void g(jc8.a r100) {
        j((ml8.a) r100);
    }

    @Override // jc8.b
    public final View h(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        ll8.b r101 = new ll8.b(r100.getContext());
        this.f514375d = r101;
        AttributeSet r102 = null;
        BrowserControlView r103 = new BrowserControlView(r101.f509707a, r102, 6, 0);
        r101.f509709c = r103;
        return r103;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v8, types: [ml8.b] */
    public final void j(final ml8.a r210) {
        Intrinsics.checkNotNullParameter(r210, "blockModel");
        ll8.b r100 = this.f514375d;
        if (r100 == null) goto L136;
        BlockContent r101 = r210.f498145a.getContent();
        Boolean r102 = null;
        if (r101 == null) goto L7;
        GUIToolBlock r103 = r101.getGuiToolBlock();
    L8:
        kc8.b r104 = (kc8.b) jc8.c.a(this, kc8.b.class);
        if (r104 == null) goto L11;
        w0 r105 = r104.f502446v;
    L12:
        String r106 = r210.f498145a.getBlockId();
        if (r106 != null) goto L15;
        String r107 = "";
    L16:
        if (r103 == null) goto L23;
        DisplayHeader r108 = r103.header;
        if (r108 == null) goto L23;
        String r109 = r108.getSummary();
        if (r109 == null) goto L23;
        String r110 = r109;
    L24:
        if (r103 == null) goto L29;
        String r111 = r103.snapshotUrl;
        if (r111 == null) goto L29;
        String r112 = r111;
    L30:
        if (r103 == null) goto L32;
        String r113 = r103.snapshotUrl;
    L33:
        boolean r114 = o0.d(r113);
        if (r103 == null) goto L41;
        DisplayHeader r115 = r103.header;
        if (r115 == null) goto L41;
        String r116 = r115.getIconUrlDark();
        if (r116 == null) goto L41;
        String r117 = r116;
    L42:
        if (r103 == null) goto L49;
        DisplayHeader r118 = r103.header;
        if (r118 == null) goto L49;
        String r119 = r118.getIconUrl();
        if (r119 == null) goto L49;
        String r120 = r119;
    L50:
        if (r105 == null) goto L52;
        ToolBlockInteractType r121 = r105.f502610a;
    L54:
        if (r121 != ToolBlockInteractType.OpenFloatingPage) goto L56;
        c r122 = new c(this, r210);
    L57:
        if (r105 == null) goto L59;
        ToolBlockInteractType r123 = r105.f502610a;
    L60:
        boolean r124 = false;
        if (r123 != ToolBlockInteractType.DisableHeaderInteract) goto L63;
        boolean r125 = true;
    L64:
        if (r105 == null) goto L66;
        ToolBlockInitStatus r126 = r105.f502611b;
    L68:
        if (r126 != null) goto L70;
        int r127 = -1;
    L71:
        if (r127 == (-1)) goto L82;
        if (r127 != 1) goto L74;
        r102 = Boolean.TRUE;
        goto L82
    L74:
        if (r127 != 2) goto L76;
        r102 = Boolean.FALSE;
        goto L82
    L76:
        if (r127 == 3) goto L82;
        throw new NoWhenBranchMatchedException();
    L82:
        nl8.a r128 = new nl8.a(r107, r110, r112, r114, r117, r120, r122, r125, r102);
        nl8.c r129 = new nl8.c(new b(this, r210));
        Intrinsics.checkNotNullParameter(r128, "vmData");
        nl8.e r130 = (nl8.e) r100.f509708b.getValue();
        r130.getClass();
        Intrinsics.checkNotNullParameter(r128, "vmData");
        r130.f519558b = r128;
        r130.f519560d = r129;
        if (Intrinsics.areEqual(r130.f519561e, r128.f519546a) == true) goto L89;
        Boolean r131 = r128.f519554i;
        if (r131 == null) goto L87;
        boolean r132 = r131.booleanValue();
    L88:
        r130.f519557a = r132;
        r130.f519561e = r128.f519546a;
        goto L89
    L87:
        r132 = false;
    L89:
        BrowserControlView r133 = r100.f509709c;
        if (r133 == null) goto L137;
        nl8.e r134 = (nl8.e) r100.f509708b.getValue();
        nl8.a r135 = r134.f519558b;
        if (r135 != null) goto L94;
    L96:
        boolean r136 = false;
    L97:
        if (r136 == false) goto L106;
        if (r135 != null) goto L100;
    L102:
        boolean r137 = false;
    L103:
        if (r137 == true) goto L106;
        r124 = true;
        goto L106
    L100:
        if (r135.f519553h != true) goto L102;
        r137 = true;
    L106:
        if (r136 == true) goto L108;
        boolean r138 = true;
    L109:
        boolean r211 = !r124;
        ButtonStatus r139 = r134.f519559c;
        if (r135 == null) goto L115;
        String r140 = r135.f519547b;
        if (r140 == null) goto L115;
        String r212 = r140;
    L116:
        if (r135 == null) goto L121;
        String r141 = r135.f519548c;
        if (r141 == null) goto L121;
        String r213 = r141;
    L122:
        if (r135 == null) goto L127;
        String r142 = r135.f519550e;
        if (r142 == null) goto L127;
        String r214 = r142;
    L128:
        if (r135 == null) goto L133;
        String r143 = r135.f519551f;
        if (r143 == null) goto L133;
        String r215 = r143;
    L134:
        r133.U5(new fj8.a(r138, r211, r211, r139, r212, r213, r214, r215), (nl8.e.a) ((nl8.e) r100.f509708b.getValue()).f519562f.getValue());
        return;
    L133:
        r215 = "";
    L127:
        r214 = "";
    L121:
        r213 = "";
    L115:
        r212 = "";
        goto L116
    L108:
        r138 = r134.f519557a;
        goto L109
    L94:
        if (r135.f519549d != true) goto L96;
        r136 = true;
        goto L97
    L137:
        return;
    L70:
        r127 = a.f514376a[r126.ordinal()];
        goto L71
    L66:
        r126 = null;
        goto L68
    L63:
        r125 = false;
        goto L64
    L59:
        r123 = null;
        goto L60
    L56:
        r122 = 0;
        goto L57
    L52:
        r121 = null;
    L49:
        r120 = "";
    L41:
        r117 = "";
        goto L42
    L32:
        r113 = null;
    L29:
        r112 = "";
    L23:
        r110 = "";
        goto L24
    L15:
        r107 = r106;
        goto L16
    L11:
        r105 = null;
        goto L12
    L7:
        r103 = null;
        goto L8
    }
}
