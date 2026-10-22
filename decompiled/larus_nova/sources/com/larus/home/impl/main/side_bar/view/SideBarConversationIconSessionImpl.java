package com.larus.home.impl.main.side_bar.view;

import android.net.Uri;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes29.dex */
public final class SideBarConversationIconSessionImpl implements gc8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Set<String>, Unit> f344811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SideBarPcAvatarController f344812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f344813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f344814d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f344815e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f344816f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f344817g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Set<String> f344818h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Set<String> f344819i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Set<String> f344820j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, wc9.e> f344821k;

    public static final class a {
    }

    public static final class b implements IIMCallback<List<? extends wc9.e>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SideBarConversationIconSessionImpl f344822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f344823b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List<String> f344824c;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return true;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            SideBarConversationIconSessionImpl r101 = this.f344822a;
            long r102 = this.f344823b;
            if (r101.f344814d == true) goto L5;
        L9:
            boolean r103 = false;
        L10:
            if (r103 == true) goto L12;
            return;
        L12:
            r101.f344820j.removeAll(CollectionsKt.toSet(this.f344824c));
            FLogger.f375446a.e("SideBarConversationIcon", "load conversations failed, errorCode=" + r100.getCode());
            return;
        L5:
            if (r101.f344815e == true) goto L9;
            if (r102 != r101.f344817g) goto L9;
            r103 = true;
            goto L10
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(List<? extends wc9.e> r100) {
            List<? extends wc9.e> r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            SideBarConversationIconSessionImpl r102 = this.f344822a;
            long r103 = this.f344823b;
            if (r102.f344814d == true) goto L5;
        L9:
            boolean r104 = false;
        L10:
            if (r104 == false) goto L19;
            r102.f344820j.removeAll(CollectionsKt.toSet(this.f344824c));
            this.f344822a.f344819i.addAll(this.f344824c);
            SideBarConversationIconSessionImpl r105 = this.f344822a;
            Iterator<T> r106 = r101.iterator();
        L14:
            if (r106.hasNext() == false) goto L16;
            wc9.e r107 = (wc9.e) r106.next();
            r105.f344821k.put(r107.f559198a, r107);
            goto L14
        L16:
            this.f344822a.e();
            this.f344822a.f344811a.invoke(CollectionsKt.toSet(this.f344824c));
            return;
        L19:
            return;
        L5:
            if (r102.f344815e == true) goto L9;
            if (r103 != r102.f344817g) goto L9;
            r104 = true;
            goto L10
        }

        public b(SideBarConversationIconSessionImpl r100, long r101, List<String> r102) {
            this.f344822a = r100;
            this.f344823b = r101;
            this.f344824c = r102;
        }
    }

    static {
    }

    @Override // gc8.b
    public final void c() {
        if (this.f344815e == false) goto L5;
        return;
    L5:
        if (this.f344814d == true) goto L10;
        this.f344814d = true;
        this.f344812b.b();
        d();
        e();
        return;
    }

    public final void d() {
        Set<String> r100 = this.f344818h;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L15;
        Object r103 = r102.next();
        String r104 = (String) r103;
        if (this.f344819i.contains(r104) == false) goto L8;
    L11:
        boolean r105 = true;
    L12:
        if (r105 == true) goto L4;
        r101.add(r103);
        goto L4
    L8:
        if (this.f344820j.contains(r104) == true) goto L11;
        r105 = false;
        goto L12
    L15:
        if (r101.isEmpty() == false) goto L17;
        return;
    L17:
        this.f344820j.addAll(r101);
        long r106 = this.f344817g;
        com.larus.im.d.d().batchGetConversationByIds(r101, new b(this, r106, r101));
    }

    @Override // gc8.b
    public final void deactivate() {
        if (this.f344814d == true) goto L5;
        return;
    L5:
        this.f344814d = false;
        this.f344817g++;
        this.f344820j.clear();
        this.f344818h = SetsKt.emptySet();
        this.f344819i.clear();
        ((LinkedHashMap) this.f344821k).clear();
        if (this.f344816f == false) goto L9;
        SideBarPcAvatarController r100 = this.f344812b;
        Object r101 = this.f344813c;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "owner");
        r100.f344847h.remove(r101);
        this.f344816f = false;
    L9:
        SideBarPcAvatarController r102 = this.f344812b;
        r102.f344844e = false;
        r102.e();
    }

    public final void e() {
        if (this.f344814d == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        boolean r101 = this.f344816f;
        if (r100 != r101) goto L12;
        return;
    L12:
        if (r100 == false) goto L14;
        SideBarPcAvatarController r102 = this.f344812b;
        Object r103 = this.f344813c;
        Function0<Unit> r104 = new v1(this);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "owner");
        Intrinsics.checkNotNullParameter(r104, "callback");
        r102.f344847h.put(r103, r104);
        r102.c();
        this.f344816f = true;
        return;
    L14:
        if (r101 == false) goto L19;
        SideBarPcAvatarController r105 = this.f344812b;
        Object r106 = this.f344813c;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "owner");
        r105.f344847h.remove(r106);
        this.f344816f = false;
        return;
    L19:
        return;
    L5:
        if ((!f().isEmpty()) == false) goto L7;
        r100 = true;
        goto L8
    }

    public final Set<String> f() {
        Set<String> r100 = this.f344818h;
        LinkedHashSet r101 = new LinkedHashSet();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L16;
        Object r103 = r102.next();
        LinkedHashMap r104 = (LinkedHashMap) this.f344821k;
        wc9.e r105 = (wc9.e) r104.get((String) r103);
        Integer r106 = null;
        if (r105 != null) goto L8;
    L11:
        if (r106 == null) goto L13;
        boolean r107 = true;
    L14:
        if (r107 == false) goto L4;
        r101.add(r103);
        goto L4
    L13:
        r107 = false;
        goto L14
    L8:
        if (ic8.n.u(r105) == true) goto L11;
        r106 = this.f344812b.a(r105);
        goto L11
    L16:
        return r101;
    }

    @Override // gc8.b
    public final void release() {
        if (this.f344815e == false) goto L5;
        return;
    L5:
        deactivate();
        SideBarPcAvatarController r100 = this.f344812b;
        r100.f344844e = false;
        r100.e();
        r100.f344847h.clear();
        this.f344815e = true;
    }

    @Override // gc8.b
    public final void a(Collection<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "conversationIds");
        if (this.f344815e == false) goto L5;
        return;
    L5:
        this.f344818h = SequencesKt.toSet(SequencesKt.filter(CollectionsKt.asSequence(r100), SideBarConversationIconSessionImpl$trackConversationIds$1.INSTANCE));
        if (this.f344814d == true) goto L8;
        return;
    L8:
        d();
        e();
    }

    @Override // gc8.b
    public final gc8.c b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        wc9.e r101 = (wc9.e) ((LinkedHashMap) this.f344821k).get(r100);
        String r102 = null;
        if (r101 != null) goto L5;
        return null;
    L5:
        int r103 = u1.f345818a;
        if (ic8.n.u(r101) == false) goto L8;
        Integer r104 = null;
    L9:
        boolean r105 = ic8.n.u(r101);
        if (r105 == true) goto L13;
        if (r104 == null) goto L13;
        return new gc8.c.a(r104.intValue());
    L13:
        if (r105 == false) goto L15;
    L17:
        if (r105 == false) goto L19;
    L21:
        IconImage r106 = r101.f559199b;
        boolean r107 = true;
        if (r106 == null) goto L35;
        ImageObj r108 = r106.imageThumb;
        if (r108 == null) goto L35;
        String r109 = r108.url;
        if (r109 == null) goto L35;
        if (r109.length() <= 0) goto L30;
        boolean r110 = true;
    L31:
        if (r110 == true) goto L34;
        r109 = null;
    L34:
        if (r109 == null) goto L35;
    L46:
        r102 = r109;
    L47:
        if (r102 == null) goto L50;
        return new gc8.c.b(r102);
    L50:
        if (ic8.n.w(r101) == true) goto L61;
        String r111 = com.larus.utils.y0.k(new Uri.Builder().scheme("res").path(String.valueOf(R.drawable.larus_common_ui_avatar_placeholder)).build());
        if (r111 != null) goto L56;
        r111 = "";
    L56:
        return new gc8.c.b(r111);
    L61:
        return new gc8.c.a(R.drawable.larus_ic_doubao_pc_empty);
    L30:
        r110 = false;
    L35:
        IconImage r112 = r101.f559199b;
        if (r112 == null) goto L47;
        ImageObj r113 = r112.imageOri;
        if (r113 == null) goto L47;
        r109 = r113.url;
        if (r109 == null) goto L47;
        if (r109.length() > 0) goto L45;
        r107 = false;
    L45:
        if (r107 == false) goto L47;
    L19:
        if (ic8.n.t(r101) == false) goto L21;
        return new gc8.c.a(R.drawable.larus_ic_side_bar_local_pc_conversation);
    L15:
        if (ic8.n.n(r101) == false) goto L17;
        return new gc8.c.a(R.drawable.larus_ic_side_bar_cloud_pc_conversation);
    L8:
        r104 = this.f344812b.a(r101);
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SideBarConversationIconSessionImpl(LifecycleOwner r100, Function1<? super Set<String>, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, "onIconsChanged");
        this.f344811a = r101;
        this.f344812b = new SideBarPcAvatarController(r100, LifecycleOwnerKt.getLifecycleScope(r100));
        this.f344813c = new Object();
        this.f344818h = SetsKt.emptySet();
        this.f344819i = new LinkedHashSet();
        this.f344820j = new LinkedHashSet();
        this.f344821k = new LinkedHashMap();
    }
}
