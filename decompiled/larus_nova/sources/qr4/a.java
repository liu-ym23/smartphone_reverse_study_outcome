package qr4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.bitable.common.widgets.item.l;
import com.bytedance.ee.bear.bitable.panel.BitablePanelItem;
import com.bytedance.ee.bear.bitable.panel.m;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements l {

    /* JADX INFO: renamed from: qr4.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC7383a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f534616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BitablePanelItem f534617b;

        public ViewOnClickListenerC7383a(m r100, BitablePanelItem r101) {
            this.f534616a = r100;
            this.f534617b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            m r101 = this.f534616a;
            if (r101 == null) goto L9;
            String r102 = this.f534617b.getId();
            if (r102 != null) goto L7;
            r102 = "";
        L7:
            r101.a(r102);
            return;
        }
    }

    public a() {
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.item.l
    public final View b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        return LayoutInflater.from(r100.getContext()).inflate(R.layout.common_panel_switch_item, r100, false);
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.item.l
    public final void a(View r100, BitablePanelItem r101, m r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        if ((r100 instanceof ViewGroup) == false) goto L5;
        ViewGroup r103 = (ViewGroup) r100;
    L6:
        if (r103 == null) goto L17;
        TextView r104 = (TextView) r103.findViewById(R.id.left_text);
        if (r104 == null) goto L13;
        r104.setEnabled(Intrinsics.areEqual(r101.getEnable(), Boolean.TRUE));
        String r105 = r101.getLeftText();
        if (r105 != null) goto L12;
        r105 = "";
    L12:
        r104.setText(r105);
    L13:
        UDSwitch r106 = (UDSwitch) r103.findViewById(R.id.button);
        if (r106 == null) goto L18;
        Boolean r107 = r101.getEnable();
        Boolean r108 = Boolean.TRUE;
        r106.setEnabled(Intrinsics.areEqual(r107, r108));
        r106.setChecked(Intrinsics.areEqual(r101.isSwitchOn(), r108));
        r106.setOnClickListener(new ViewOnClickListenerC7383a(r102, r101));
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
