package com.bytedance.ee.bear.wikiv2.wikitreev2.main;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.c0;
import com.bytedance.ee.bear.contract.route.parcelable.WikiDocument;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.route.PostCard;
import com.bytedance.ee.bear.wikiv2.home.api.DisplayTag;
import com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeActivityContract;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetSpaceInfoPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.StarSpacePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.UnStarSpacePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.g0;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.l0;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceUserPerm;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0002+,B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0012\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u0014\u001a\u00020\u0011J\r\u0010\u0015\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0016J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0018J\u0006\u0010\u0019\u001a\u00020\tJ\b\u0010\u001a\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u001b\u001a\u00020\u0011J\b\u0010\u001c\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u001d\u001a\u00020\u0011J\u0006\u0010\u001e\u001a\u00020\u0011J\u0006\u0010\u001f\u001a\u00020\u0011J\u0006\u0010 \u001a\u00020\u0013J\u0006\u0010!\u001a\u00020\u0013J\u0006\u0010\"\u001a\u00020\u0013J\u0018\u0010#\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u0011H\u0002J\u0018\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)J\b\u0010*\u001a\u00020\u0013H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/SpaceHomeViewModel;", "Landroidx/lifecycle/ViewModel;", "contract", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/WikiTreeActivityContract;", "<init>", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/WikiTreeActivityContract;)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "spaceId", "", "documentToken", "spaceInfo", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/SpaceInfo;", "spaceUserPerm", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/SpaceUserPerm;", "spaceStar", "Landroidx/lifecycle/MutableLiveData;", "", "setReady", "", "isSpaceStar", "isGraphDark", "()Ljava/lang/Boolean;", "isSpaceStarLiveData", "Landroidx/lifecycle/LiveData;", "getSpaceId", "getDocumentToken", "canViewCollaborator", "getSpaceInfo", "isPublicScope", "isOpenSharing", "hasCover", "showSpaceDetail", "favoriteSpace", "unFavoriteSpace", "notifyListSetCacheStar", "star", "navigation", "params", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/NavigationParams;", "fragment", "Landroidx/fragment/app/Fragment;", "onCleared", "Companion", "Factory", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpaceHomeViewModel extends ViewModel {
    public static final c Companion = null;
    private static final String TAG = "WikiTreeViewModel";
    private final CompositeDisposable disposables;
    private String documentToken;
    private String spaceId;
    private SpaceInfo spaceInfo;
    private MutableLiveData<Boolean> spaceStar;
    private SpaceUserPerm spaceUserPerm;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ SpaceHomeViewModel a;

        public a(SpaceHomeViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            MutableLiveData r0 = SpaceHomeViewModel.access$getSpaceStar$p(this.a);
            r0.setValue((Boolean) r2);
        }
    }

    public static final class b<T> implements Consumer {
        public static final b<T> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r4) {
            tt5.a.e(SpaceHomeViewModel.TAG, "getSpaceInfo fail. ", (Throwable) r4, false);
        }
    }

    public static final class c {
        public c() {
        }

        @JvmStatic
        public static SpaceHomeViewModel a(ViewModelStoreOwner r2, WikiTreeActivityContract r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "contract");
            return (SpaceHomeViewModel) new ViewModelProvider(r2, new d(r3)).get(SpaceHomeViewModel.class);
        }
    }

    public static final class d implements ViewModelProvider.Factory {
        public final WikiTreeActivityContract a;

        public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
            return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
        }

        public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
            return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
        }

        public d(WikiTreeActivityContract r2) {
            Intrinsics.checkNotNullParameter(r2, "contract");
            this.a = r2;
        }

        public final <T extends ViewModel> T create(Class<T> r2) {
            Intrinsics.checkNotNullParameter(r2, "modelClass");
            return new SpaceHomeViewModel(this.a);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ SpaceHomeViewModel a;

        public e(SpaceHomeViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            SpaceHomeViewModel.access$getSpaceStar$p(this.a).setValue(Boolean.TRUE);
            Toast.showSuccessText(eu5.b.a, 2131888352);
            SpaceHomeViewModel r5 = this.a;
            SpaceHomeViewModel.access$notifyListSetCacheStar(r5, SpaceHomeViewModel.access$getSpaceId$p(r5), true);
        }
    }

    public static final class f<T> implements Consumer {
        public static final f<T> a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            tt5.a.i(SpaceHomeViewModel.TAG, "star space fail. ", r4);
            if (tp5.b.b(r4, 920004024) == false) goto L5;
            int r5 = 2131887473;
        L6:
            Toast.showFailureText(eu5.b.a, r5);
            return;
        L5:
            r5 = 2131888351;
            goto L6
        }
    }

    public static final class g<T, R> implements Function {
        public static final g<T, R> a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final Object apply(Object r3) {
            Intrinsics.checkNotNullParameter((String) r3, "it");
            return (c0) org.koin.java.a.c(c0.class, null, null, 6);
        }
    }

    public static final class h<T, R> implements Function {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;

        public h(String r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r3) {
            c0 r4 = (c0) r3;
            Intrinsics.checkNotNullParameter(r4, "listDataService");
            r4.o0(this.a, this.b);
            return Boolean.TRUE;
        }
    }

    public static final class i<T> implements Consumer {
        public static final i<T> a = null;

        static {
            a = new i();
        }

        public i() {
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            tt5.a.h(SpaceHomeViewModel.TAG, "notifyListSetCacheStar ok. ");
        }
    }

    public static final class j<T> implements Consumer {
        public static final j<T> a = null;

        static {
            a = new j();
        }

        public j() {
        }

        public final void accept(Object r3) {
            tt5.a.f(SpaceHomeViewModel.TAG, (Throwable) r3, false);
        }
    }

    public static final class k<T, R> implements Function {
        public static final k<T, R> a = null;

        static {
            a = new k();
        }

        public k() {
        }

        public final Object apply(Object r2) {
            SpaceInfo r3 = (SpaceInfo) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return Boolean.valueOf(r3.is_star);
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ SpaceHomeViewModel a;

        public l(SpaceHomeViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            SpaceHomeViewModel.access$getSpaceStar$p(this.a).setValue(Boolean.FALSE);
            Toast.showSuccessText(eu5.b.a, 2131888359);
            SpaceHomeViewModel r5 = this.a;
            SpaceHomeViewModel.access$notifyListSetCacheStar(r5, SpaceHomeViewModel.access$getSpaceId$p(r5), false);
        }
    }

    public static final class m<T> implements Consumer {
        public static final m<T> a = null;

        static {
            a = new m();
        }

        public m() {
        }

        public final void accept(Object r3) {
            Toast.showFailureText(eu5.b.a, 2131888358);
            tt5.a.i(SpaceHomeViewModel.TAG, "unstar space fail. ", (Throwable) r3);
        }
    }

    static {
        Companion = new c();
    }

    @JvmStatic
    public static final SpaceHomeViewModel newInstance(ViewModelStoreOwner r1, WikiTreeActivityContract r2) {
        Companion.getClass();
        return c.a(r1, r2);
    }

    public final boolean canViewCollaborator() {
        SpaceUserPerm r0 = this.spaceUserPerm;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.view_wiki_general_info != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void favoriteSpace() {
        gq5.d.n(new gq5.d.g("star_workspace", null, this.spaceId, 4084));
        this.disposables.add(new StarSpacePuller((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).c(new StarSpacePuller.Params(this.spaceId)).map(new g0()).subscribe(new e(this), f.a));
    }

    public final boolean hasCover() {
        SpaceInfo r0 = this.spaceInfo;
        String r1 = null;
        if (r0 == null) goto L5;
        SpaceInfo.SpaceCover r2 = r0.space_cover;
    L6:
        if (r2 == null) goto L11;
        if (r0 == null) goto L9;
        r1 = r0.getSpaceName();
    L9:
        if (r1 == null) goto L11;
        return true;
    L11:
        return false;
    L5:
        r2 = null;
        goto L6
    }

    public final Boolean isGraphDark() {
        SpaceInfo r0 = this.spaceInfo;
        if (r0 == null) goto L7;
        SpaceInfo.SpaceCover r1 = r0.space_cover;
        if (r1 == null) goto L7;
        return Boolean.valueOf(r1.is_graph_dark);
    L7:
        return null;
    }

    public final boolean isOpenSharing() {
        SpaceInfo r0 = this.spaceInfo;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isOpenSharing();
    }

    public final boolean isPublicScope() {
        SpaceInfo r0 = this.spaceInfo;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isPublicScope();
    }

    public final boolean isSpaceStar() {
        Boolean r0 = (Boolean) this.spaceStar.getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    public final void showSpaceDetail() {
        String r4 = null;
        gq5.d.n(new gq5.d.g("workspace_detail", null, this.spaceId, 4084));
        PostCard r0 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).w2("/wikiv2/space/detail/activity");
        SpaceInfo r1 = this.spaceInfo;
        if (r1 == null) goto L5;
        String r2 = r1.space_id;
    L6:
        PostCard r3 = r0.i("space_id", r2);
        SpaceInfo r5 = this.spaceInfo;
        if (r5 == null) goto L9;
        r4 = r5.description;
    L9:
        r3.i("EXTRA_WIKI_DESCRIPTION", r4).e();
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void unFavoriteSpace() {
        gq5.d.n(new gq5.d.g("unstar_workspace", null, this.spaceId, 4084));
        this.disposables.add(new UnStarSpacePuller((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).c(new UnStarSpacePuller.Params(this.spaceId)).map(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.t()).subscribe(new l(this), m.a));
    }

    public void onCleared() {
        super.onCleared();
        this.disposables.clear();
    }

    public final String getDocumentToken() {
        return this.documentToken;
    }

    public final String getSpaceId() {
        return this.spaceId;
    }

    public final SpaceInfo getSpaceInfo() {
        return this.spaceInfo;
    }

    public final LiveData<Boolean> isSpaceStarLiveData() {
        return this.spaceStar;
    }

    public SpaceHomeViewModel(WikiTreeActivityContract r8) {
        Intrinsics.checkNotNullParameter(r8, "contract");
        CompositeDisposable r0 = new CompositeDisposable();
        this.disposables = r0;
        this.spaceId = "";
        this.spaceStar = new MutableLiveData();
        this.spaceId = r8.getSpaceId();
        this.documentToken = r8.getDocumentToken();
        Intrinsics.checkNotNullParameter(r8, "<this>");
        SpaceInfo r1 = new SpaceInfo();
        r1.space_id = r8.getSpaceId();
        WikiDocument r2 = r8.getWikiDocument();
        if (r2 == null) goto L5;
        String r3 = r2.a;
    L6:
        r1.space_name = r3;
        WikiDocument r4 = r8.getWikiDocument();
        if (r4 == null) goto L9;
        String r5 = r4.P2;
    L10:
        r1.description = r5;
        WikiDocument r6 = r8.getWikiDocument();
        boolean r7 = false;
        if (r6 == null) goto L13;
        int r9 = r6.U2;
    L14:
        r1.wiki_scope = r9;
        WikiDocument r10 = r8.getWikiDocument();
        if (r10 == null) goto L17;
        int r11 = r10.V2;
    L18:
        r1.open_sharing = r11;
        WikiDocument r12 = r8.getWikiDocument();
        if (r12 == null) goto L21;
        DisplayTag r13 = r12.W2;
    L22:
        r1.display_tag = r13;
        WikiDocument r14 = r8.getWikiDocument();
        if (r14 == null) goto L25;
        boolean r15 = r14.z;
    L26:
        r1.is_star = r15;
        WikiDocument r16 = r8.getWikiDocument();
        if (r16 == null) goto L29;
        WikiDocument.SpaceCover r17 = r16.R2;
    L30:
        if (r17 == null) goto L32;
        SpaceInfo.SpaceCover r18 = new SpaceInfo.SpaceCover();
        r18.origin = r17.a;
        r18.thumbnail = r17.b;
        r18.key = r17.c;
        r18.is_graph_dark = r17.d;
        r18.color_value = r17.e;
        r1.space_cover = r18;
    L32:
        this.spaceInfo = r1;
        if (r8.getWikiDocument() == null) goto L38;
        WikiDocument r19 = r8.getWikiDocument();
        if (r19 == null) goto L37;
        r7 = r19.z;
    L37:
        Flowable r20 = Flowable.just(Boolean.valueOf(r7));
        Intrinsics.checkNotNull(r20);
    L39:
        r0.add(r20.subscribe(new a(this), b.a));
        return;
    L38:
        r20 = l0.c((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).a(new GetSpaceInfoPuller.Params(this.spaceId)).map(k.a);
        Intrinsics.checkNotNull(r20);
        goto L39
    L29:
        r17 = null;
        goto L30
    L25:
        r15 = false;
        goto L26
    L21:
        r13 = null;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public static final /* synthetic */ String access$getSpaceId$p(SpaceHomeViewModel r0) {
        return r0.spaceId;
    }

    public static final /* synthetic */ MutableLiveData access$getSpaceStar$p(SpaceHomeViewModel r0) {
        return r0.spaceStar;
    }

    private final void notifyListSetCacheStar(String r4, boolean r5) {
        this.disposables.add(Flowable.just("").subscribeOn(fo5.d.b()).map(g.a).map(new h(r4, r5)).subscribe(i.a, j.a));
    }

    public final void navigation(com.bytedance.ee.bear.wikiv2.wikitreev2.main.c r9, Fragment r10) {
        Intrinsics.checkNotNullParameter(r9, "params");
        Bundle r4 = new Bundle();
        r4.putString("ccm_open_type", r9.a);
        String r0 = r9.e;
        if (r0 == null) goto L5;
        r4.putString("title", r0);
    L5:
        WikiInfo r1 = r9.f;
        if (r1 == null) goto L8;
        r4.putSerializable("wiki_info", r1);
    L8:
        String r2 = r9.g;
        if (r2 == null) goto L11;
        r4.putString("unique_ui_id", r2);
    L11:
        String r3 = r9.h;
        if (r3 == null) goto L14;
        r4.putString("extra_from", r3);
    L14:
        String r5 = r9.c;
        if (r5 != null) goto L17;
        r5 = this.spaceId;
    L17:
        String r6 = r5;
        String r7 = r9.d;
        if (r7 != null) goto L23;
        SpaceInfo r8 = this.spaceInfo;
        if (r8 == null) goto L22;
        r7 = r8.getSpaceName();
        goto L23
    L22:
        r7 = null;
    L23:
        o.b(r6, r7, r9.b, r4, Boolean.FALSE, r10, r9.i);
    }

    public final void setReady(SpaceInfo r1, SpaceUserPerm r2) {
        this.spaceInfo = r1;
        this.spaceUserPerm = r2;
    }

    public static final /* synthetic */ void access$notifyListSetCacheStar(SpaceHomeViewModel r0, String r1, boolean r2) {
        r0.notifyListSetCacheStar(r1, r2);
    }
}
