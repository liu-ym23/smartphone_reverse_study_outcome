package com.ss.android.lark.integrator.im.sticker;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.larksuite.framework.callback.IGetDataCallback;
import com.suite.lark.platform.service.resourcerepository.api.Resource;
import com.suite.lark.platform.service.resourcerepository.api.ResourceRequestBaseSet;
import h6c.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
@ClaymoreImpl(a.class)
public class OfficeStickerDependencyImpl implements a {

    /* JADX INFO: renamed from: com.ss.android.lark.integrator.im.sticker.OfficeStickerDependencyImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements a6c.a {
        public AnonymousClass1() {
        }

        public final Map<String, c6c.a> b(Map<String, Resource> r100) {
            HashMap r101 = new HashMap();
            if (r100 == null) goto L14;
            Iterator<String> r102 = r100.keySet().iterator();
        L6:
            if (r102.hasNext() == false) goto L14;
            String r103 = r102.next();
            Resource r104 = r100.get(r103);
            if (r104 == null) goto L10;
            c6c.a r105 = new c6c.a(r104.f461376a, r104.f461377b);
        L11:
            if (r105 == null) goto L6;
            r101.put(r103, r105);
            goto L6
        L10:
            r105 = null;
        L14:
            return r101;
        }

        @Override // a6c.a
        public final Map<String, c6c.a> a(String r100, List<String> r101) {
            ArrayList r102 = new ArrayList();
            Iterator<String> r103 = r101.iterator();
        L4:
            if (r103.hasNext() == false) goto L7;
            r102.add(new ResourceRequestBaseSet(r103.next(), r100, null, null));
            goto L4
        L7:
            return b(nmb.a.a().getCoreDependency().f().synGetResources(r102));
        }

        @Override // a6c.a
        public Map<String, c6c.a> getResources(String r100, List<String> r101) {
            ArrayList r102 = new ArrayList();
            Iterator<String> r103 = r101.iterator();
        L4:
            if (r103.hasNext() == false) goto L7;
            r102.add(new ResourceRequestBaseSet(r103.next(), r100, null, null));
            goto L4
        L7:
            return b(nmb.a.a().getCoreDependency().f().getResources(r102));
        }

        @Override // a6c.a
        public void getResources(String r100, List<String> r101, final IGetDataCallback<Map<String, c6c.a>> r102) {
            ArrayList r103 = new ArrayList();
            Iterator<String> r104 = r101.iterator();
        L4:
            if (r104.hasNext() == false) goto L6;
            r103.add(new ResourceRequestBaseSet(r104.next(), r100, null, null));
            goto L4
        L6:
            nmb.a.a().getCoreDependency().f().getResources(r103, -99, new C50711(this, r102));
        }
    }

    public OfficeStickerDependencyImpl() {
    }

    @Override // h6c.a
    public a6c.a getResourceDependency() {
        return new AnonymousClass1();
    }
}
