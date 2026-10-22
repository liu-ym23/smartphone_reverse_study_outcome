package sdc;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.photopicker.s;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import rdc.j;
import rdc.t;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements ldc.f<t, com.ss.android.lark.widget.photopickerimpl.view.large.a.b<t>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f541524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f541525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final rdc.d f541526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.ss.android.lark.widget.photopickerimpl.view.large.a.b<t> f541527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AppCompatCheckBox f541528e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f541529f;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f541530a;

        public a(d r100) {
            this.f541530a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.ss.android.lark.widget.photopickerimpl.view.large.a.b<t> r101 = this.f541530a.f541527d;
            if (r101 == null) goto L6;
            r101.finish();
            return;
        }
    }

    @Override // ldc.f
    public final void c(Map<Integer, com.ss.android.lark.widget.photopickerimpl.bean.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "dirInfos");
    }

    @Override // ldc.f
    public final boolean onActivityResult(int r100, int r101, Intent r102) {
        Intrinsics.checkNotNullParameter(r102, "data");
        return false;
    }

    @Override // ldc.f
    public final void onResume() {
    }

    @Override // ldc.f
    public final void onStop() {
    }

    @Override // ldc.f
    public final void a(t r100) {
        t r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        AppCompatCheckBox r102 = this.f541528e;
        if (r102 == null) goto L5;
        r102.setChecked(r101.f537388m);
    L5:
        AppCompatCheckBox r103 = this.f541528e;
        if (r103 == null) goto L8;
        r103.setText(r101.f537387l);
    L8:
        AppCompatCheckBox r104 = this.f541528e;
        if (r104 == null) goto L12;
        r104.setOnClickListener(new e(r101, this));
        return;
    }

    @Override // ldc.f
    public final View b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.photo_picker_new_large_top_tool, r100, false);
        this.f541529f = (ImageView) r101.findViewById(R.id.btn_back);
        this.f541528e = (AppCompatCheckBox) r101.findViewById(R.id.cb_select_photo);
        ImageView r102 = this.f541529f;
        if (r102 == null) goto L5;
        r102.setOnClickListener(new a(this));
    L5:
        Intrinsics.checkNotNull(r101);
        return r101;
    }

    @Override // ldc.f
    public final void d(com.ss.android.lark.widget.photopickerimpl.view.large.a.b<t> r100) {
        com.ss.android.lark.widget.photopickerimpl.view.large.a.b<t> r101 = r100;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f541527d = r101;
    }

    public d(Context r100, s r101, j r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "pickerParams");
        Intrinsics.checkNotNullParameter(r102, "selectedListener");
        this.f541524a = r100;
        this.f541525b = r101;
        this.f541526c = r102;
    }
}
