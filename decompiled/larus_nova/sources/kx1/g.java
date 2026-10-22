package kx1;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.feedback.Option;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class g extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f506546a;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f506547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Option f506548b;

        public a(d r100, Option r101) {
            this.f506547a = r100;
            this.f506548b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f506547a.a(this.f506548b);
        }
    }

    public final View a(int r100) {
        if (this.f506546a != null) goto L5;
        this.f506546a = new LinkedHashMap();
    L5:
        View r101 = this.f506546a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f506546a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public g(Context r100, Option r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "option");
        Intrinsics.checkNotNullParameter(r102, "listener");
        super(r100, null, 0);
        this.f506546a = new LinkedHashMap();
        View.inflate(r100, R.layout.ttlive_layout_feedback_preview_option, this);
        TextView r103 = (TextView) a(R.id.option_view);
        String r104 = r101.text;
        if (r104 != null) goto L6;
        r104 = "";
    L6:
        r103.setText(r104);
        TextView r105 = (TextView) a(R.id.option_view);
        Boolean r106 = r101.negative;
        Boolean r107 = Boolean.TRUE;
        if (Intrinsics.areEqual(r106, r107) == false) goto L9;
        int r108 = -16777216;
    L10:
        r105.setTextColor(r108);
        if (Intrinsics.areEqual(r101.negative, r107) == false) goto L13;
        int r109 = R.drawable.ttlive_bg_feedback_preview_option_negative;
    L14:
        ((ConstraintLayout) a(R.id.root_view)).setBackground(s1.m(r109));
        setOnClickListener(new a(r102, r101));
        return;
    L13:
        r109 = R.drawable.ttlive_bg_feedback_preview_option_positive;
        goto L14
    L9:
        r108 = -1;
        goto L10
    }
}
