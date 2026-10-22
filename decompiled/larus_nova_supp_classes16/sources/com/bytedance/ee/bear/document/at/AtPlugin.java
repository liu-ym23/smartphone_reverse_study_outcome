package com.bytedance.ee.bear.document.at;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.atfinder.MentionModel;
import com.bytedance.ee.bear.bean.MentionPanelType;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.document.authors.Author;
import com.bytedance.ee.bear.document.authors.AuthorsPlugin;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.utils.AtUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class AtPlugin extends BaseMentionPlugin {
    private static final String TAG = "AtPlugin";
    private ArrayList<String> authorIds;
    private boolean isOwner;
    private String ownerId;

    public class a extends q {
        public final /* synthetic */ AtPlugin b;

        public final bo4.c a() {
            ((i0) org.koin.java.a.a(i0.class)).a();
            return new bo4.c(kn4.f.a().e(), kn4.f.a().f());
        }

        public a(AtPlugin r1) {
            this.b = r1;
        }

        @Override // com.bytedance.ee.bear.document.at.q
        public final List<Disposable> b(MentionModel r3) {
            AtPlugin r0 = this.b;
            r3.setChatId(AtPlugin.access$100(r0, r0.getDocumentMetadata().getUrl()));
            r3.setOwnerId(AtPlugin.access$200(this.b));
            r3.setOwner(AtPlugin.access$300(this.b));
            r3.setAuthorIds(AtPlugin.access$400(this.b));
            return super.b(r3);
        }

        @Override // com.bytedance.ee.bear.document.at.q
        public final void c(ArrayList<ln4.m> r19) {
            String r2 = this.b.getDocumentMetadata().getBearUrl().a;
            ln4.m r10 = new ln4.m(2131237952, AtPlugin.access$500(this.b).getString(2131887572), Arrays.asList(com.bytedance.ee.bear.utils.a.c), MentionPanelType.user, AtPlugin.access$600(this.b), 2131889125);
            ln4.m r3 = new ln4.m(2131255787, AtPlugin.access$700(this.b).getString(2131887569), AtUtils.c(), MentionPanelType.file, AtPlugin.access$600(this.b), 2131889122);
            r19.add(r10);
            r19.add(r3);
            if (sbb.e.k.getType().equals(r2) == true) goto L6;
            r19.add(new ln4.m(2131254837, AtPlugin.access$800(this.b).getString(2131887570), Arrays.asList(com.bytedance.ee.bear.utils.a.d), MentionPanelType.chat, AtPlugin.access$600(this.b), 2131889124));
            return;
        }
    }

    public static /* synthetic */ void c(AtPlugin r0, List r1) {
        r0.lambda$onAttachToHost$0(r1);
    }

    public static /* synthetic */ void d(AtPlugin r0, DocumentInfo r1) {
        r0.lambda$onAttachToHost$2(r1);
    }

    public static /* synthetic */ void e(AtPlugin r0, AuthorsPlugin r1) {
        r0.lambda$onAttachToHost$1(r1);
    }

    @Override // com.bytedance.ee.bear.document.at.BaseMentionPlugin, com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.document.at.BaseMentionPlugin
    public com.bytedance.ee.bear.atfinder.e onCreateMentionDelegate() {
        return new a(this);
    }

    public AtPlugin() {
        this.authorIds = new ArrayList();
    }

    private com.bytedance.ee.bear.atfinder.f getMentionSearch() {
        return kn4.f.a().b();
    }

    public static /* synthetic */ String access$200(AtPlugin r0) {
        return r0.ownerId;
    }

    public static /* synthetic */ boolean access$300(AtPlugin r0) {
        return r0.isOwner;
    }

    public static /* synthetic */ ArrayList access$400(AtPlugin r0) {
        return r0.authorIds;
    }

    public static /* synthetic */ Context access$500(AtPlugin r0) {
        return r0.getContext();
    }

    public static /* synthetic */ com.bytedance.ee.bear.atfinder.f access$600(AtPlugin r0) {
        return r0.getMentionSearch();
    }

    public static /* synthetic */ Context access$700(AtPlugin r0) {
        return r0.getContext();
    }

    public static /* synthetic */ Context access$800(AtPlugin r0) {
        return r0.getContext();
    }

    private String getChatId(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return "";
    L5:
        String r4 = UriProtector.getQueryParameter(UriProtector.parse(r3), "chat_id");
        if (r4 != null) goto L9;
        return "";
    L9:
        return r4;
    }

    private /* synthetic */ void lambda$onAttachToHost$0(List r4) {
        tt5.a.h(TAG, "authors updated. size: " + r4.size());
        ArrayList<String> r0 = new ArrayList();
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Author r1 = (Author) r5.next();
        if (r1.getId() == null) goto L4;
        r0.add(r1.getId());
        goto L4
    L8:
        this.authorIds = r0;
    }

    private /* synthetic */ void lambda$onAttachToHost$1(AuthorsPlugin r3) {
        r3.getAuthorsLiveData().observe(getLifecycleOwner(), new p(this));
    }

    private /* synthetic */ void lambda$onAttachToHost$2(DocumentInfo r2) {
        this.ownerId = r2.getOwnerUid();
        this.isOwner = r2.isOwner();
        tt5.a.h(TAG, "documentInfo updated. ownerId: " + this.ownerId + ", isOwner: " + this.isOwner);
    }

    @Override // com.bytedance.ee.bear.document.at.BaseMentionPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r3) {
        super.onAttachToHost(r3);
        m.a();
        r3.findPluginToDo(AuthorsPlugin.class, new n(this));
        ((w05.b) getHostAbility(w05.b.class)).getDocumentInfoProvider().j().observe(getLifecycleOwner(), new o(this));
    }

    public static /* synthetic */ String access$100(AtPlugin r0, String r1) {
        return r0.getChatId(r1);
    }
}
