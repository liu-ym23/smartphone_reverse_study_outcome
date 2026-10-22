package com.bytedance.ee.bear.drive.biz.docplugin;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceThirdPartyOpenEntity;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.doc.follow.impl.r;
import com.bytedance.ee.bear.doc.follow.impl.t;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.drive.core.fragment.DriveMainFragment;
import com.bytedance.ee.bear.drive.core.fragment.UserContainerDriveMainFragment;
import com.bytedance.ee.drive.preview.f;
import com.bytedance.ee.drive.render.j;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.l0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import l65.g;
import z05.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public final BasePlugin a;
    public final FragmentActivity b;
    public final LifecycleOwner c;
    public final d d;
    public final List<com.bytedance.ee.bear.drive.biz.docplugin.a> e;
    public final List<SpaceThirdPartyOpenEntity> f;
    public final Map<String, String> g;

    public interface a {
    }

    public final Pair<Boolean, List<SpaceThirdPartyOpenEntity>> a() {
        if (((CopyOnWriteArrayList) this.f).isEmpty() == false) goto L6;
        tt5.a.h("CCMFollow_AttachmentFollowManager", "doAllBlockAttachFileFragmentClose fail, fullsreen entity list is empty");
        return new Pair(Boolean.FALSE, new CopyOnWriteArrayList());
    L6:
        CopyOnWriteArrayList r0 = new CopyOnWriteArrayList();
        int r2 = ((CopyOnWriteArrayList) this.f).size();
        int r3 = 0;
        boolean r4 = false;
    L7:
        if (r3 >= r2) goto L16;
        BaseOpenEntity r5 = (BaseOpenEntity) ListProtector.get(this.f, r3);
        String r6 = (String) ((HashMap) this.g).get(c(r5));
        if (r6 == null) goto L11;
        AttachmentFollowVM r7 = (AttachmentFollowVM) new ViewModelProvider(this.b).get(r6, AttachmentFollowVM.class);
    L12:
        tt5.a.h("CCMFollow_AttachmentFollowManager", "getAttachmentFollowVMFromCache uuid=" + r6 + ", attachmentFollowVM=" + r7);
        if (r7 == null) goto L15;
        r7.getCloseCMD().postValue(null);
        r0.add(ListProtector.get(this.f, r3));
        r4 = true;
    L15:
        r3 = r3 + 1;
        goto L7
    L11:
        r7 = null;
        goto L12
    L16:
        tt5.a.h("CCMFollow_AttachmentFollowManager", "doAllBlockAttachFileFragmentClose " + r4 + ", size=" + r2);
        ((CopyOnWriteArrayList) this.f).clear();
        return new Pair(Boolean.valueOf(r4), r0);
    }

    public final void d() {
        tt5.a.h("CCMFollow_AttachmentFollowManager", "stopAllVCFollowObserve");
        Iterator r0 = ((ArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        com.bytedance.ee.bear.drive.biz.docplugin.a r1 = (com.bytedance.ee.bear.drive.biz.docplugin.a) r0.next();
        if (r1.c == false) goto L4;
        tt5.a.h("CCMFollow_AttachmentFollowPluginWrapper", "AttachmentFollowPluginWrapper is onSetDown");
        r1.c = false;
        r1.b.getFileBlockPresenterState().removeObserver(r1.f);
        goto L4
    L9:
        ((ArrayList) this.e).clear();
        ((HashMap) this.g).clear();
    }

    public static String c(BaseOpenEntity r2) {
        if ((r2 instanceof SpaceThirdPartyOpenEntity) == false) goto L5;
        String r0 = ((SpaceThirdPartyOpenEntity) r2).getMountNodeToken();
    L7:
        return r2.getFileId() + OfflineDoc.DASH_DELIMITER + r0;
    L5:
        r0 = "";
        goto L7
    }

    public c(BasePlugin r2, FragmentActivity r3, LifecycleOwner r4, d r5) {
        this.e = new ArrayList();
        this.f = new CopyOnWriteArrayList();
        this.g = new HashMap();
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    public final UserContainerDriveMainFragment b(ArrayList r7, int r8, String r9, com.bytedance.ee.bear.drive.module.nativepreview.a r10) {
        String r0 = l0.a().toString();
        tt5.a.h("CCMFollow_AttachmentFollowManager", "openFollowableFragment: uuid = " + r0);
        Iterator r1 = r7.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        BaseOpenEntity r3 = (BaseOpenEntity) r1.next();
        ((HashMap) this.g).put(c(r3), r0);
        goto L4
    L6:
        g r2 = new g(new b(this));
        r2.d = true;
        r2.b = r9;
        r2.e = r0;
        AttachmentFollowVM r11 = (AttachmentFollowVM) new ViewModelProvider(this.b).get(r0, AttachmentFollowVM.class);
        tt5.a.h("CCMFollow_AttachmentFollowManager", "startVCFollowObserve: attachmentFollowVM = " + r11);
        LifecycleOwner r4 = this.c;
        com.bytedance.ee.bear.drive.biz.docplugin.a r5 = new com.bytedance.ee.bear.drive.biz.docplugin.a(r4, r11, r10);
        ((ArrayList) this.e).add(r5);
        if (r5.c == true) goto L10;
        tt5.a.h("CCMFollow_AttachmentFollowPluginWrapper", "AttachmentFollowPluginWrapper is onSetUp");
        r5.c = true;
        r11.getFileBlockPresenterState().observe(r4, r5.f);
    L10:
        j r12 = ((f) org.koin.java.a.a(f.class)).U4(this.b);
        int r13 = DriveMainFragment.l;
        UserContainerDriveMainFragment r14 = DriveMainFragment.a.a(r12, r7, r8, r2, null);
        pw4.a r16 = (pw4.a) this.a.getHostAbilityOrNull(pw4.a.class);
        if (r16 == null) goto L13;
        String r17 = r16.getFollowApiHostId();
    L14:
        tt5.a.h("CCMFollow_AttachmentFollowManager", "getFollowApiHostId = " + r17);
        Map<String, Pair<py4.c, r>> r18 = t.a;
        tt5.a.h("CCMFollow_FragHelper", "wrapHostArgs hostId:" + r17);
        Bundle r19 = r14.getArguments();
        if (r19 != null) goto L17;
        r19 = new Bundle();
    L17:
        r19.putString("argFollowApiHostId", r17);
        String r6 = r19.getString("url");
        if (TextUtils.isEmpty(r6) == true) goto L20;
        r19.putString("url", i.c(r6));
    L20:
        BearUrl r20 = (BearUrl) r19.getParcelable("bear_url");
        if (r20 == null) goto L23;
        r20.e = i.c(r20.e);
        r20.n = null;
        r19.putParcelable("bear_url", r20);
    L23:
        r14.setArguments(r19);
        return r14;
    L13:
        r17 = null;
        goto L14
    }
}
