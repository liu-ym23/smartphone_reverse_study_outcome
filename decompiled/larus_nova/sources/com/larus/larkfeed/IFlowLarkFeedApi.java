package com.larus.larkfeed;

import androidx.fragment.app.Fragment;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.d;
import com.ss.android.lark.feed.export.feedcard.f;
import com.ss.android.lark.feed.export.feedcard.h;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000  2\u00020\u0001:\u0001 J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H&J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u0012H&J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0019H&J\b\u0010\u001e\u001a\u00020\u0012H&J\b\u0010\u001f\u001a\u00020\u0012H&¨\u0006!"}, d2 = {"Lcom/larus/larkfeed/IFlowLarkFeedApi;", "", "createSocialConversationPageFragment", "Landroidx/fragment/app/Fragment;", "createSocialAddressBookFragment", "getConversationFeedCardTransformer", "Lcom/ss/android/lark/feed/export/feedcard/IFeedCardTransformer;", "getConversationFeedCell", "Lcom/ss/android/lark/feed/export/feedcard/IOpenFeedCell;", "getConversationSideBarFeedCell", "getConversationFeedAction", "Lcom/ss/android/lark/feed/export/feedcard/action/IOpenFeedAction;", "feedCardContext", "Lcom/ss/android/lark/feed/export/feedcard/IFeedCardContext;", "createMixedFeedFragment", "isDouBaoFeedMigrateFinished", "", "markDouBaoFeedMigrateFinished", "", "transformConversationToLocalFeedCards", "", "Lcom/ss/android/lark/feed/app/entity/UIFeedCard;", "dataList", "setSidebarFlowClickHint", "feedId", "", "clearSidebarFlowClickHint", "createConversationFeedUpdateNotifier", "Lcom/larus/larkfeed/IConversationFeedUpdateNotifier;", "tag", "registerLarkFeedGlobalListeners", "notifyUserLoginFailed", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IFlowLarkFeedApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f355117a = null;

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\t\u0010\n\u001a\u00020\u000bH\u0096\u0001J\t\u0010\f\u001a\u00020\u000bH\u0096\u0001J\t\u0010\r\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0015H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u001b\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\tH\u0096\u0001J\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u001fH\u0096\u0001¨\u0006#"}, d2 = {"Lcom/larus/larkfeed/IFlowLarkFeedApi$Companion;", "Lcom/larus/larkfeed/IFlowLarkFeedApi;", "<init>", "()V", "clearSidebarFlowClickHint", "", "createConversationFeedUpdateNotifier", "Lcom/larus/larkfeed/IConversationFeedUpdateNotifier;", "tag", "", "createMixedFeedFragment", "Landroidx/fragment/app/Fragment;", "createSocialAddressBookFragment", "createSocialConversationPageFragment", "getConversationFeedAction", "Lcom/ss/android/lark/feed/export/feedcard/action/IOpenFeedAction;", "feedCardContext", "Lcom/ss/android/lark/feed/export/feedcard/IFeedCardContext;", "getConversationFeedCardTransformer", "Lcom/ss/android/lark/feed/export/feedcard/IFeedCardTransformer;", "getConversationFeedCell", "Lcom/ss/android/lark/feed/export/feedcard/IOpenFeedCell;", "getConversationSideBarFeedCell", "isDouBaoFeedMigrateFinished", "", "markDouBaoFeedMigrateFinished", "notifyUserLoginFailed", "registerLarkFeedGlobalListeners", "setSidebarFlowClickHint", "feedId", "transformConversationToLocalFeedCards", "", "Lcom/ss/android/lark/feed/app/entity/UIFeedCard;", "dataList", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IFlowLarkFeedApi {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f355118c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IFlowLarkFeedApi f355119b;

        static {
            f355118c = new Companion();
        }

        @Override // com.larus.larkfeed.IFlowLarkFeedApi
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "feedId");
            this.f355119b.a(r100);
        }

        @Override // com.larus.larkfeed.IFlowLarkFeedApi
        public final Fragment b() {
            return this.f355119b.b();
        }

        @Override // com.larus.larkfeed.IFlowLarkFeedApi
        public final nh9.a c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            return this.f355119b.c(r100);
        }

        @Override // com.larus.larkfeed.IFlowLarkFeedApi
        public final f d() {
            return this.f355119b.d();
        }

        @Override // com.larus.larkfeed.IFlowLarkFeedApi
        public final void e() {
            this.f355119b.e();
        }

        @Override // com.larus.larkfeed.IFlowLarkFeedApi
        public final boolean f() {
            return this.f355119b.f();
        }

        @Override // com.larus.larkfeed.IFlowLarkFeedApi
        public final aeb.f g(d r100) {
            Intrinsics.checkNotNullParameter(r100, "feedCardContext");
            return this.f355119b.g(r100);
        }

        @Override // com.larus.larkfeed.IFlowLarkFeedApi
        public final void h() {
            this.f355119b.h();
        }

        @Override // com.larus.larkfeed.IFlowLarkFeedApi
        public final void i() {
            this.f355119b.i();
        }

        @Override // com.larus.larkfeed.IFlowLarkFeedApi
        public final h j() {
            return this.f355119b.j();
        }

        @Override // com.larus.larkfeed.IFlowLarkFeedApi
        public final Fragment k() {
            return this.f355119b.k();
        }

        @Override // com.larus.larkfeed.IFlowLarkFeedApi
        public final Fragment l() {
            return this.f355119b.l();
        }

        @Override // com.larus.larkfeed.IFlowLarkFeedApi
        public final List<UIFeedCard> m(List<? extends Object> r100) {
            Intrinsics.checkNotNullParameter(r100, "dataList");
            return this.f355119b.m(r100);
        }

        @Override // com.larus.larkfeed.IFlowLarkFeedApi
        public final h n() {
            return this.f355119b.n();
        }

        private Companion() {
            this.f355119b = (IFlowLarkFeedApi) ServiceManager.get().getService(IFlowLarkFeedApi.class);
        }
    }

    static {
        f355117a = Companion.f355118c;
    }

    void a(String r100);

    Fragment b();

    nh9.a c(String r100);

    f d();

    void e();

    boolean f();

    aeb.f g(d r100);

    void h();

    void i();

    h j();

    Fragment k();

    Fragment l();

    List<UIFeedCard> m(List<? extends Object> r100);

    h n();
}
