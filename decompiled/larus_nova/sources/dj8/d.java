package dj8;

import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.chat.block.base.config.ToolBlockInitStatus;
import com.larus.bmhome.chat.block.base.config.ToolBlockInteractType;
import com.larus.bmhome.chat.standarduikit.browsercontrol.view.BrowserControlView;
import com.larus.bmhome.chat.standarduikit.browsercontrol.view.ButtonStatus;
import com.larus.bmhome.chat.standarduikit.browsercontrol.vm.BrowserControlViewModel;
import com.larus.bmhome.chat.standarduikit.browsercontrol.vm.BrowserControlViewModel$browserControlBlockOutput$2$1;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BrowserControlBlock;
import com.larus.im.bean.message.block.BrowserControlUserAction;
import com.larus.im.bean.message.block.DisplayHeader;
import jc8.e;
import kc8.w0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d extends jc8.b<dj8.a> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public cj8.c f468958d;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f468959a = null;

        static {
            int[] r100 = new int[ToolBlockInitStatus.values().length];
            r100[ToolBlockInitStatus.Fold.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ToolBlockInitStatus.Expand.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ToolBlockInitStatus.Default.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f468959a = r100;
        }
    }

    @Override // jc8.b
    public final String c() {
        return "BrowserControlBlockHolder";
    }

    public d() {
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r100) {
        dj8.a r101 = (dj8.a) r100;
        Intrinsics.checkNotNullParameter(r101, "blockModel");
        return e.d(r101);
    }

    @Override // jc8.b
    public final /* bridge */ /* synthetic */ void g(jc8.a r100) {
        j((dj8.a) r100);
    }

    @Override // jc8.b
    public final View h(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        cj8.c r101 = new cj8.c(r100.getContext());
        this.f468958d = r101;
        BrowserControlView r102 = (BrowserControlView) r101.f23987a.getValue();
        if (r102 == null) goto L5;
        return r102;
    L5:
        return new View(r100.getContext());
    }

    /* JADX WARN: Type inference failed for: r6v15, types: [dj8.b] */
    /* JADX WARN: Type inference failed for: r6v19, types: [dj8.c] */
    public final void j(final dj8.a r210) {
        Intrinsics.checkNotNullParameter(r210, "blockModel");
        BlockContent r100 = r210.f498145a.getContent();
        if (r100 == null) goto L5;
        BrowserControlBlock r101 = r100.getBrowserControlBlock();
    L6:
        kc8.b r102 = (kc8.b) jc8.c.a(this, kc8.b.class);
        if (r102 == null) goto L9;
        final w0 r103 = r102.f502446v;
    L10:
        cj8.c r104 = this.f468958d;
        if (r104 == null) goto L158;
        String r105 = r210.f498145a.getBlockId();
        if (r105 != null) goto L15;
        String r106 = "";
    L16:
        if (r101 == null) goto L20;
        DisplayHeader r107 = r101.displayHeader;
        if (r107 == null) goto L20;
        String r108 = r107.getSummary();
    L21:
        if (r108 != null) goto L23;
        String r110 = "";
    L24:
        if (r101 == null) goto L28;
        DisplayHeader r109 = r101.displayHeader;
        if (r109 == null) goto L28;
        String r111 = r109.getIconUrlDark();
    L29:
        if (r111 != null) goto L31;
        String r112 = "";
    L32:
        if (r101 == null) goto L36;
        DisplayHeader r113 = r101.displayHeader;
        if (r113 == null) goto L36;
        String r114 = r113.getIconUrl();
    L37:
        if (r114 != null) goto L39;
        String r115 = "";
    L40:
        if (r101 == null) goto L42;
        String r116 = r101.snapshotUrl;
    L43:
        if (r116 != null) goto L45;
        String r117 = "";
    L46:
        if (r101 == null) goto L48;
        String r118 = r101.toolCallId;
    L49:
        if (r118 != null) goto L51;
        String r119 = "";
    L52:
        BrowserControlUserAction.a r120 = BrowserControlUserAction.Companion;
        if (r101 == null) goto L55;
        Integer r121 = r101.action;
    L56:
        r120.getClass();
        BrowserControlUserAction[] r122 = BrowserControlUserAction.values();
        int r123 = r122.length;
        int r124 = 0;
    L57:
        if (r124 >= r123) goto L68;
        BrowserControlUserAction r125 = r122[r124];
        int r126 = r125.getValue();
        if (r121 != null) goto L62;
    L64:
        boolean r127 = false;
    L65:
        if (r127 == true) goto L69;
        r124 = r124 + 1;
    L69:
        if (r125 != null) goto L71;
        BrowserControlUserAction r128 = BrowserControlUserAction.DONE;
    L72:
        if (r103 == null) goto L74;
        ToolBlockInteractType r129 = r103.f502610a;
    L76:
        if (r129 != ToolBlockInteractType.DisableHeaderInteract) goto L78;
        boolean r130 = true;
    L79:
        if (r103 == null) goto L81;
        ToolBlockInitStatus r131 = r103.f502611b;
    L83:
        if (r131 != null) goto L85;
        int r132 = -1;
    L86:
        if (r132 != (-1)) goto L88;
    L99:
        Boolean r133 = null;
    L100:
        com.larus.bmhome.chat.standarduikit.browsercontrol.vm.a r134 = new com.larus.bmhome.chat.standarduikit.browsercontrol.vm.a(r106, r128, r119, r110, r117, r112, r115, new b(r103, this, r210), r130, r133);
        kc8.b r135 = (kc8.b) jc8.c.a(this, kc8.b.class);
        com.larus.bmhome.chat.standarduikit.browsercontrol.vm.c r136 = new com.larus.bmhome.chat.standarduikit.browsercontrol.vm.c(new c(this, r210));
        Intrinsics.checkNotNullParameter(r134, "vmData");
        BrowserControlViewModel r137 = (BrowserControlViewModel) r104.f23988b.getValue();
        r137.getClass();
        Intrinsics.checkNotNullParameter(r134, "vmData");
        r137.f308938a = r134;
        r137.f308939b = r136;
        if (Intrinsics.areEqual(r137.f308943f, r134.f308946a) == true) goto L108;
        Boolean r138 = r134.f308955j;
        if (r138 == null) goto L105;
        boolean r139 = r138.booleanValue();
    L106:
        r137.f308942e = r139;
        r137.f308943f = r134.f308946a;
        r137.f308941d = false;
        goto L108
    L105:
        r139 = false;
    L108:
        if (r137.f308942e == false) goto L111;
        r137.f308940c = ButtonStatus.HIDE;
    L117:
        BrowserControlViewModel r140 = (BrowserControlViewModel) r104.f23988b.getValue();
        com.larus.bmhome.chat.standarduikit.browsercontrol.vm.a r141 = r140.f308938a;
        if (r141 == null) goto L123;
        String r142 = r141.f308949d;
        if (r142 == null) goto L123;
        String r143 = r142;
    L124:
        if (r141 == null) goto L129;
        String r144 = r141.f308951f;
        if (r144 == null) goto L129;
        String r145 = r144;
    L130:
        if (r141 == null) goto L135;
        String r146 = r141.f308952g;
        if (r146 == null) goto L135;
        String r147 = r146;
    L136:
        if (r141 == null) goto L141;
        String r148 = r141.f308950e;
        if (r148 == null) goto L141;
        String r149 = r148;
    L142:
        ButtonStatus r150 = r140.f308940c;
        boolean r151 = r140.f308942e;
        if (r141 == null) goto L147;
        boolean r152 = true;
        if (r141.f308954i != true) goto L148;
        boolean r153 = true;
    L149:
        if (r141 != null) goto L151;
    L153:
        boolean r154 = false;
    L154:
        fj8.a r155 = new fj8.a(r151, r153, r154, r150, r143, r149, r145, r147);
        BrowserControlViewModel$browserControlBlockOutput$2$1 r156 = (BrowserControlViewModel$browserControlBlockOutput$2$1) ((BrowserControlViewModel) r104.f23988b.getValue()).f308944g.getValue();
        ((BrowserControlView) r104.f23987a.getValue()).U5(r155, r156);
        return;
    L151:
        if (r141.f308954i != r152) goto L153;
        r154 = true;
    L148:
        r153 = false;
        goto L149
    L147:
        r152 = true;
    L141:
        r149 = "";
    L135:
        r147 = "";
    L129:
        r145 = "";
    L123:
        r143 = "";
        goto L124
    L111:
        if (r134.f308947b == BrowserControlUserAction.WAIT) goto L113;
        r137.f308940c = ButtonStatus.HIDE;
        goto L117
    L113:
        if (r137.f308941d == false) goto L115;
        r137.f308940c = ButtonStatus.DISABLED;
        goto L117
    L115:
        r137.f308940c = ButtonStatus.ENABLED;
        goto L117
    L88:
        if (r132 != 1) goto L90;
        Boolean r157 = Boolean.TRUE;
    L98:
        r133 = r157;
        goto L100
    L90:
        if (r132 != 2) goto L92;
        r157 = Boolean.FALSE;
        goto L98
    L92:
        if (r132 == 3) goto L99;
        throw new NoWhenBranchMatchedException();
    L85:
        r132 = a.f468959a[r131.ordinal()];
        goto L86
    L81:
        r131 = null;
        goto L83
    L78:
        r130 = false;
        goto L79
    L74:
        r129 = null;
        goto L76
    L71:
        r128 = r125;
        goto L72
    L62:
        if (r126 != r121.intValue()) goto L64;
        r127 = true;
        goto L65
    L68:
        r125 = null;
        goto L69
    L55:
        r121 = null;
        goto L56
    L51:
        r119 = r118;
        goto L52
    L48:
        r118 = null;
        goto L49
    L45:
        r117 = r116;
        goto L46
    L42:
        r116 = null;
        goto L43
    L39:
        r115 = r114;
    L36:
        r114 = null;
        goto L37
    L31:
        r112 = r111;
    L28:
        r111 = null;
        goto L29
    L23:
        r110 = r108;
    L20:
        r108 = null;
        goto L21
    L15:
        r106 = r105;
        goto L16
    L158:
        return;
    L9:
        r103 = null;
        goto L10
    L5:
        r101 = null;
        goto L6
    }
}
