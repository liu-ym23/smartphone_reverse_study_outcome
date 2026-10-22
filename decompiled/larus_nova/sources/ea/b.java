package ea;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.annie.view.WebRiskHintView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebRiskHintView f471555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f471556b;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebRiskHintView f471557a;

        public a(WebRiskHintView r100) {
            this.f471557a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ViewGroup r101 = this.f471557a.f40100c;
            if (r101 == null) goto L7;
            r101.setVisibility(8);
            return;
        }
    }

    public b(WebRiskHintView r100, String r101) {
        this.f471555a = r100;
        this.f471556b = r101;
    }

    public final void a() {
        WebRiskHintView r100 = this.f471555a;
        r100.f40100c = (ViewGroup) LayoutInflater.from(r100.getContext()).inflate(R.layout.annie_web_risk_hint_layout, this.f471555a);
        WebRiskHintView r101 = this.f471555a;
        ViewGroup r102 = r101.f40100c;
        ImageView r103 = null;
        if (r102 == null) goto L5;
        TextView r104 = (TextView) r102.findViewById(R.id.annie_web_risk_info_tv);
    L6:
        r101.f40098a = r104;
        WebRiskHintView r105 = this.f471555a;
        ViewGroup r106 = r105.f40100c;
        if (r106 == null) goto L9;
        r103 = (ImageView) r106.findViewById(R.id.annie_web_risk_close_banner_iv);
    L9:
        r105.f40099b = r103;
        WebRiskHintView r107 = this.f471555a;
        ImageView r108 = r107.f40099b;
        if (r108 == null) goto L12;
        r108.setOnClickListener(new a(r107));
    L12:
        TextView r109 = this.f471555a.f40098a;
        if (r109 == null) goto L17;
        r109.setText(this.f471556b);
        return;
    L17:
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
