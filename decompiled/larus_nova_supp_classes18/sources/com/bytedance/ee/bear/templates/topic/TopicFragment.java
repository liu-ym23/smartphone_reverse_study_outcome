package com.bytedance.ee.bear.templates.topic;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.templates.center.TemplateCenterViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020$H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/templates/topic/TopicFragment;", "Lcom/bytedance/ee/bear/templates/topic/BaseTopicFragment;", "<init>", "()V", "topicId", "", "getTopicId", "()Ljava/lang/String;", "setTopicId", "(Ljava/lang/String;)V", "filterType", "", "getFilterType", "()I", "setFilterType", "(I)V", "fixedFilter", "", "getFixedFilter", "()Z", "setFixedFilter", "(Z)V", "viewModel", "Lcom/bytedance/ee/bear/templates/center/TemplateCenterViewModel;", "getViewModel", "()Lcom/bytedance/ee/bear/templates/center/TemplateCenterViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initData", "getIModel", "Lcom/bytedance/ee/bear/templates/topic/TopicModel;", "getIView", "Lcom/bytedance/ee/bear/templates/topic/ITopicView;", "rootView", "Landroid/view/View;", "getIPresenter", "Lcom/bytedance/ee/bear/templates/topic/BaseTopicPresenter;", "model", "view", "Companion", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TopicFragment extends BaseTopicFragment {
    public static final /* synthetic */ int i = 0;
    public String e;
    public int f;
    public boolean g;
    public final Lazy h;

    public static final class a {
        public static TopicFragment a(Context r2, String r3, int r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "topicId");
            Fragment r6 = Fragment.instantiate(r2, TopicFragment.class.getName(), new Bundle());
            Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.bytedance.ee.bear.templates.topic.TopicFragment");
            TopicFragment r7 = (TopicFragment) r6;
            r7.getClass();
            Intrinsics.checkNotNullParameter(r3, "<set-?>");
            r7.e = r3;
            r7.f = r4;
            r7.g = r5;
            return r7;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.templates.topic.BaseTopicFragment
    public final TopicModel S90() {
        return new TopicModel(requireActivity());
    }

    public TopicFragment() {
        this.e = "";
        this.f = -1;
        this.h = LazyKt.lazy(new TopicFragment$viewModel$2(this));
    }

    @Override // com.bytedance.ee.bear.templates.topic.BaseTopicFragment
    public final BaseTopicView U90(View r8) {
        Intrinsics.checkNotNullParameter(r8, "rootView");
        return new BaseTopicView(requireActivity(), this, r8, this.e, this.g);
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (this.f == (-1)) goto L6;
        ((TemplateCenterViewModel) this.h.getValue()).saveFilter(this.f);
        return;
    }

    @Override // com.bytedance.ee.bear.templates.topic.BaseTopicFragment
    public final BaseTopicPresenter T90(TopicModel r2, e r3) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r3, "view");
        return new BaseTopicPresenter(this, r2, r3);
    }
}
