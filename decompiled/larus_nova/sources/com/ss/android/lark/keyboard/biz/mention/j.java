package com.ss.android.lark.keyboard.biz.mention;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.widget.BottomSheet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes36.dex */
public final class j extends BottomSheet {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Activity f428466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f428467e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f428468f;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f428469a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f428470b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f428471c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f428472d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f428473e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f428474f;

        public b(View r100) {
            Intrinsics.checkNotNullParameter(r100, "rootView");
            this.f428469a = r100;
            this.f428470b = r100.findViewById(R.id.close_bt);
            this.f428471c = (ImageView) r100.findViewById(R.id.avatar);
            this.f428472d = (TextView) r100.findViewById(R.id.tip_title);
            this.f428473e = (TextView) r100.findViewById(R.id.tip_desc);
            this.f428474f = (TextView) r100.findViewById(R.id.confirm_btn);
        }
    }

    static {
    }

    public j(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        super(r100);
        this.f428466d = r100;
        this.f428468f = LazyKt.lazy(FlowMentionDoubaoTip$model$2.INSTANCE);
    }

    @Override // com.ss.android.lark.keyboard.widget.BottomSheet
    public final View a(ViewGroup r110) {
        Intrinsics.checkNotNullParameter(r110, KtvSubElement.CONTAINER);
        View r111 = LayoutInflater.from(r110.getContext()).inflate(R.layout.at_doubao_tip, r110, false);
        Intrinsics.checkNotNull(r111);
        b r100 = new b(r111);
        this.f428467e = r100;
        r100.f428470b.setOnClickListener(new k(this));
        r100.f428474f.setOnClickListener(new l(this));
        r100.f428474f.setText(UIUtils.getString(this.f428466d, R.string.Lark_Group_RevokeIKnow));
        ComponentCallbacks2 r101 = this.f428466d;
        if ((r101 instanceof LifecycleOwner) == false) goto L5;
        LifecycleOwner r102 = (LifecycleOwner) r101;
    L6:
        if (r102 == null) goto L9;
        BuildersKt.launch$default(LifecycleKt.getCoroutineScope(r102.getLifecycle()), null, null, new FlowMentionDoubaoTip$loadDoubaoAvatarIfNeed$1(this, r100, null), 3, null);
    L9:
        return r111;
    L5:
        r102 = null;
        goto L6
    }
}
