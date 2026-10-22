package com.larksuite.component.blockit.props;

import android.app.Application;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import com.larksuite.component.blockit.entity.ItemTags;
import com.larksuite.component.blockit.entity.TagInstance;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.z;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.LarkContext;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes24.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f283121a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f283122a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f283123b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i f283124c;

        public final void a() {
            d r100 = this.f283124c.f283121a;
            WeakReference r101 = (WeakReference) ((ConcurrentHashMap) r100.f283112a).get(this.f283122a);
            if (r101 == null) goto L5;
            PropsView r102 = (PropsView) r101.get();
        L6:
            if (r102 == null) goto L8;
            r102.setText(c.a(this.f283123b, r102.f283105e));
            r102.setMovementMethod(LinkMovementMethod.getInstance());
        L8:
            d r103 = this.f283124c.f283121a;
            List r104 = (List) ((ConcurrentHashMap) r103.f283113b).get(this.f283122a);
            if (CollectionUtils.isEmpty(r104) == true) goto L14;
            Iterator r105 = r104.iterator();
        L12:
            if (r105.hasNext() == false) goto L16;
            com.larksuite.component.blockit.props.a r106 = (com.larksuite.component.blockit.props.a) r105.next();
            this.f283123b.size();
            r106.a();
            ((SpannableStringBuilder) c.a(this.f283123b, null)).toString();
            r106.b();
            goto L12
        L16:
            return;
        L14:
            return;
        L5:
            r102 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(i r100, String r101, List r102) {
            this.f283124c = r100;
            this.f283122a = r101;
            this.f283123b = r102;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f283125a = null;

        static {
            f283125a = new i();
        }
    }

    public i() {
        this.f283121a = new d();
    }

    public final void a(final String r100, Map<String, ItemTags> r101) {
        final Application r102 = LarkContext.getApplication();
        if (z.e(r102) == false) goto L6;
        final Future<?> r103 = CoreThreadPool.getDefault().getFixedThreadPool().submit(new g(this, r102, r100));
        CoreThreadPool.getBackgroundHandler().postDelayed(new h(r103), 5000);
    L6:
        ArrayList r104 = new ArrayList();
        Iterator<ItemTags> r105 = r101.values().iterator();
    L8:
        if (r105.hasNext() == false) goto L15;
        ItemTags r106 = r105.next();
        if (TextUtils.equals(r100, r106.uniqId) == false) goto L8;
        Iterator<TagInstance> r107 = r106.tags.iterator();
    L13:
        if (r107.hasNext() == false) goto L8;
        TagInstance r108 = r107.next();
        TagInstance.BasicTagInfo r109 = r108.tagInfo;
        r104.add(new f(r109.name, r108.appLink, r109.tagId));
        goto L13
    L15:
        UICallbackExecutor.execute(new a(this, r100, r104));
    }
}
