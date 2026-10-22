package com.ss.android.lark.keyboard.plugin.tool.voice.vote;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes36.dex */
public class d extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f430847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final osb.e f430848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f430849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView f430850d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f430851e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public UDButton f430852f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f430853g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DownVoteReasonAdapter f430854h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DownVoteInputAdapter f430855i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ConcatAdapter f430856j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CoroutineScope f430857k;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f430858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f430859b;

        public b(d r100, View r101) {
            this.f430858a = r100;
            this.f430859b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            KeyboardUtils.hideKeyboard(this.f430858a.getContext(), this.f430859b);
        }
    }

    public static final class c implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f430860a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ConstraintLayout f430861b;

        public c(View r100, ConstraintLayout r101) {
            this.f430860a = r100;
            this.f430861b = r101;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
            Intrinsics.checkNotNullParameter(r100, "<unused var>");
            Intrinsics.checkNotNullParameter(r101, "insets");
            Insets r102 = r101.getInsets(WindowInsetsCompat.Type.ime());
            if (r102.bottom <= this.f430860a.getPaddingBottom()) goto L5;
            this.f430861b.setTranslationY(-r102.bottom);
        L6:
            return r101;
        L5:
            this.f430861b.setTranslationY(0.0f);
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.vote.d$d, reason: collision with other inner class name */
    public static final class ViewOnLayoutChangeListenerC5115d implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f430862a;

        public ViewOnLayoutChangeListenerC5115d(d r100) {
            this.f430862a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            if (r101 != r105) goto L7;
            if (r102 != r106) goto L7;
            if (r103 != r107) goto L7;
            if (r104 != r108) goto L7;
            return;
        L7:
            d r109 = this.f430862a;
            Intrinsics.checkNotNull(r100);
            r109.b(r100);
        }
    }

    static {
    }

    public void a() {
        ArrayList r100 = new ArrayList();
        List<String> r101 = this.f430847a;
        if (r101 == null) goto L12;
        Iterator<T> r102 = r101.iterator();
        int r103 = 0;
    L6:
        if (r102.hasNext() == false) goto L12;
        Object r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        r100.add(new DownVoteReasonAdapter.b(String.valueOf(r103), (String) r104));
        r103 = r105;
    L12:
        if ((!r100.isEmpty()) == false) goto L18;
        DownVoteReasonAdapter r106 = this.f430854h;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r100, "reasonList");
        ((ArrayList) r106.f430833b).clear();
        ((ArrayList) r106.f430833b).addAll(r100);
        r106.notifyDataSetChanged();
        return;
    }

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
        CoroutineScopeKt.cancel$default(this.f430857k, null, 1, null);
    }

    public final void b(View r100) {
        Window r101 = getWindow();
        if (r101 == null) goto L20;
        r101.setGravity(80);
        r101.setWindowAnimations(R.style.DownVoteFeedbackDialogAnimation);
        Resources r102 = r101.getContext().getResources();
        int r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).widthPixels;
        Resources r104 = r101.getContext().getResources();
        int r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).heightPixels;
        int r106 = (int) (((double) r105) * 0.9d);
        Log.d("FeedbackDialog", "screenWidth: " + r103 + ", screenHeight: " + r105 + ", maxDialogHeight: " + r106);
        r100.measure(View.MeasureSpec.makeMeasureSpec(r103, 1073741824), View.MeasureSpec.makeMeasureSpec(r105, 0));
        int r107 = r100.getMeasuredHeight();
        StringBuilder r108 = new StringBuilder("measuredHeight: ");
        r108.append(r107);
        Log.d("FeedbackDialog", r108.toString());
        if (r107 > r106) goto L7;
        r106 = r107;
    L7:
        Log.d("FeedbackDialog", "finalDialogHeight: " + r106);
        ViewGroup.LayoutParams r109 = r100.getLayoutParams();
        if (r109 != null) goto L10;
        r109 = new ViewGroup.LayoutParams(-1, -2);
    L10:
        r109.height = r106;
        r100.setLayoutParams(r109);
        RecyclerView r110 = this.f430850d;
        if (r110 == null) goto L14;
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        if (r111 == null) goto L14;
    L15:
        RecyclerView r112 = this.f430850d;
        if (r112 == null) goto L18;
        r112.setLayoutParams(r111);
    L18:
        r101.setLayout(-1, r106);
        return;
    L14:
        r111 = new ViewGroup.LayoutParams(-1, -2);
        goto L15
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r110) {
        super.onCreate(r110);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(true);
        Window r100 = getWindow();
        if (r100 == null) goto L5;
        WindowCompat.setDecorFitsSystemWindows(r100, false);
    L5:
        UDButton r101 = null;
        View r102 = LayoutInflater.from(getContext()).inflate(R.layout.dialog_down_vote_feedback, null);
        setContentView(r102);
        View r103 = findViewById(R.id.close);
        if (r103 == null) goto L8;
        r103.setOnClickListener(new uob.c(this));
    L9:
        this.f430849c = r103;
        TextView r104 = (TextView) findViewById(R.id.title);
        if (r104 == null) goto L12;
        r104.setTextSize(0, zz7.b.g(r104.getContext(), 17));
    L12:
        RecyclerView r105 = (RecyclerView) findViewById(R.id.recycler_view);
        if (r105 == null) goto L18;
        r105.setLayoutManager(new LinearLayoutManager(r105.getContext()));
        r105.setAdapter(this.f430856j);
        DividerItemDecoration r106 = new DividerItemDecoration(r105.getContext(), 1);
        Drawable r107 = ResourcesCompat.getDrawable(r105.getContext().getResources(), R.drawable.bg_down_vote_reason_divider, r105.getContext().getTheme());
        if (r107 == null) goto L17;
        r106.setDrawable(r107);
    L17:
        r105.addItemDecoration(r106);
    L19:
        this.f430850d = r105;
        TextView r108 = (TextView) findViewById(R.id.privacy_disclaimer);
        if (r108 == null) goto L22;
        r108.setTextSize(0, zz7.b.g(r108.getContext(), 12));
    L23:
        this.f430851e = r108;
        UDButton r109 = (UDButton) findViewById(R.id.submit);
        if (r109 == null) goto L26;
        r109.setTextSize(0, zz7.b.g(r109.getContext(), 17));
        r109.setEnabled(true);
        r109.setOnClickListener(new e(this, r109));
        r101 = r109;
    L26:
        this.f430852f = r101;
        a();
        this.f430853g = r102;
        Intrinsics.checkNotNull(r102);
        b(r102);
        r102.setOnClickListener(new b(this, r102));
        ViewCompat.setOnApplyWindowInsetsListener(r102, new c(r102, (ConstraintLayout) r102.findViewById(R.id.content_container)));
        r102.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC5115d(this));
        return;
    L22:
        r108 = null;
        goto L23
    L18:
        r105 = null;
        goto L19
    L8:
        r103 = null;
        goto L9
    }

    public d(Context r100, List<String> r101, osb.e r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "clickListener");
        super(r100, R.style.DownVoteFeedbackDialog);
        this.f430847a = r101;
        this.f430848b = r102;
        DownVoteReasonAdapter r103 = new DownVoteReasonAdapter();
        this.f430854h = r103;
        DownVoteInputAdapter r104 = new DownVoteInputAdapter();
        this.f430855i = r104;
        this.f430856j = new ConcatAdapter(new RecyclerView.Adapter[]{r103, r104});
        this.f430857k = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }
}
