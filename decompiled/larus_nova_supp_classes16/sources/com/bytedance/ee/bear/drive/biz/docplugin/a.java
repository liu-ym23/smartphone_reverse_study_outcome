package com.bytedance.ee.bear.drive.biz.docplugin;

import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceThirdPartyOpenEntity;
import com.bytedance.ee.bear.drive.module.nativepreview.DriveSameRenderLifecyclePlugin;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final LifecycleOwner a;
    public final AttachmentFollowVM b;
    public volatile boolean c;
    public final c.a d;
    public Boolean e;
    public final C0121a f;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.docplugin.a$a, reason: collision with other inner class name */
    public class C0121a implements Observer<Pair<Boolean, SpaceThirdPartyOpenEntity>> {
        public final /* synthetic */ a a;

        public C0121a(a r1) {
            this.a = r1;
        }

        public final void onChanged(Object r8) {
            Pair r9 = (Pair) r8;
            if (this.a.d != null) goto L5;
            tt5.a.d("CCMFollow_AttachmentFollowPluginWrapper", "fileBlock observer call is null");
            return;
        L5:
            Boolean r0 = (Boolean) r9.component1();
            SpaceThirdPartyOpenEntity r10 = (SpaceThirdPartyOpenEntity) r9.component2();
            tt5.a.h("CCMFollow_AttachmentFollowPluginWrapper", "fileBlock observer : fileBlockState=" + r0);
            Boolean r1 = this.a.e;
            if (r1 != null) goto L8;
        L28:
            this.a.e = r0;
            return;
        L8:
            if (r1.equals(r0) == true) goto L28;
            this.a.e = r0;
            if (Boolean.TRUE.equals(r0) == false) goto L14;
            ((com.bytedance.ee.bear.drive.module.nativepreview.a) this.a.d).a.a.exitAttachFileFragmentIfNeed();
            return;
        L14:
            if (Boolean.FALSE.equals(r0) == false) goto L36;
            com.bytedance.ee.bear.drive.module.nativepreview.a r2 = (com.bytedance.ee.bear.drive.module.nativepreview.a) this.a.d;
            c r3 = DriveSameRenderLifecyclePlugin.access$1200(r2.a.a);
            if (r10 != null) goto L18;
            r3.getClass();
        L27:
            DriveSameRenderLifecyclePlugin.access$1300(r2.a.a, r10);
            return;
        L18:
            int r4 = ((CopyOnWriteArrayList) r3.f).size();
            int r5 = 0;
        L19:
            if (r5 >= r4) goto L26;
            SpaceThirdPartyOpenEntity r6 = (SpaceThirdPartyOpenEntity) ListProtector.get(r3.f, r5);
            if (TextUtils.equals(r6.getFileId(), r10.getFileId()) == false) goto L25;
            if (TextUtils.equals(r6.getMountNodeToken(), r10.getMountNodeToken()) == true) goto L27;
        L25:
            r5 = r5 + 1;
            goto L19
        L26:
            ((CopyOnWriteArrayList) r3.f).add(r10);
            goto L27
        }
    }

    public a(LifecycleOwner r2, AttachmentFollowVM r3, com.bytedance.ee.bear.drive.module.nativepreview.a r4) {
        this.e = null;
        this.f = new C0121a(this);
        this.a = r2;
        this.b = r3;
        this.d = r4;
    }
}
