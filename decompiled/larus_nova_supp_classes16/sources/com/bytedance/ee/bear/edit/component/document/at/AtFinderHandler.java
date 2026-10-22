package com.bytedance.ee.bear.edit.component.document.at;

import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.at.AtObject;
import com.bytedance.ee.bear.atfinder.AtFinderJsCallbackData;
import com.bytedance.ee.bear.atfinder.AtFinderResultList;
import com.bytedance.ee.bear.document.at.q;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.io.NonProguard;
import io.reactivex.Flowable;
import java.util.Iterator;
import java.util.Map;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class AtFinderHandler implements tb5.i<AtFinderJsCallbackData> {
    public m a;
    public b b;
    public AtPanelViewModel c;
    public final a d;

    public static class AtFinderNativeCallbackData extends AtFinderResultList {
        private boolean isCanceled;

        @JSONField(name = "isCheckboxSelected")
        private boolean isCheckboxSelected;

        public String toString() {
            return "AtFinderNativeCallbackData{isCanceled=" + this.isCanceled + ", isCheckboxSelected=" + this.isCheckboxSelected + '}';
        }

        public AtFinderNativeCallbackData() {
        }

        public boolean isCanceled() {
            return this.isCanceled;
        }

        public boolean isCheckboxSelected() {
            return this.isCheckboxSelected;
        }

        public void setCanceled(boolean r1) {
            this.isCanceled = r1;
        }

        public void setCheckboxSelected(boolean r1) {
            this.isCheckboxSelected = r1;
        }
    }

    public class a implements com.bytedance.ee.bear.atfinder.d {
        public final /* synthetic */ AtFinderHandler a;

        public final void c(String r1) {
        }

        public final void d(String r1) {
        }

        public final void b() {
            tt5.a.b("AtFinderHandler", "onClosedView: ");
            Flowable.just(Boolean.TRUE).observeOn(fo5.d.d()).subscribe(new com.bytedance.ee.bear.edit.component.document.at.a(this), new com.bytedance.ee.bear.edit.component.document.at.b());
        }

        public a(AtFinderHandler r1) {
            this.a = r1;
        }

        public final void a(AtFinderResultList r8, boolean r9) {
            if (this.a.c.getMentionDelegate() == null) goto L5;
            ((q) this.a.c.getMentionDelegate()).getClass();
            tt5.a.b("BaseMentionDelegate", "onSelectData ");
        L5:
            this.a.getClass();
            if (r8 != null) goto L8;
        L32:
            tt5.a.d("AtFinderHandler", "encode: list is null");
        L33:
            NonProguard r2 = new AtFinderNativeCallbackData();
            r2.setData(r8.getData());
            r2.setCanceled(false);
            r2.setCheckboxSelected(r9);
            m r10 = this.a.a;
            if (r10 != null) goto L36;
            tt5.a.d("AtFinderHandler", "responseData: mCallbackFun is null");
            return;
        L36:
            r10.a(r2);
            return;
        L8:
            if (r8.getData() == null) goto L32;
            if (r8.getData().getResult_list() == null) goto L32;
            Iterator r3 = r8.getData().getResult_list().iterator();     // Catch: Exception -> L30
        L13:
            if (r3.hasNext() == false) goto L33;
            AtObject r4 = (AtObject) r3.next();     // Catch: Exception -> L30
            String r6 = "";
            if (TextUtils.isEmpty(r4.getContent()) == false) goto L19;
            String r5 = "";
        L20:
            r4.setContent(r5);     // Catch: Exception -> L30
            if (TextUtils.isEmpty(r4.getDepartment()) == false) goto L23;
            String r7 = "";
        L24:
            r4.setDepartment(r7);     // Catch: Exception -> L30
            if (TextUtils.isEmpty(r4.getDesc()) == true) goto L28;
            r6 = Base64.encodeToString(r4.getDesc().getBytes("UTF-8"), 0);     // Catch: Exception -> L30
        L28:
            r4.setDesc(r6);     // Catch: Exception -> L30
            goto L13
        L23:
            r7 = Base64.encodeToString(r4.getDepartment().getBytes("UTF-8"), 0);     // Catch: Exception -> L30
            goto L24
        L19:
            r5 = Base64.encodeToString(r4.getContent().getBytes("UTF-8"), 0);     // Catch: Exception -> L30
        L30:
            e = move-exception;
            tt5.a.e("AtFinderHandler", "encode: ", e, false);
            goto L33
        }
    }

    public interface b {
        void a(String r1, String r2);

        void b();
    }

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public AtFinderHandler() {
        this.d = new a(this);
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r6, m r7) {
        AtFinderJsCallbackData r8 = (AtFinderJsCallbackData) r6;
        if (r8 == null) goto L18;
        if (r7 == null) goto L18;
        b r1 = this.b;
        if (r1 == null) goto L14;
        r1.b();
        if (r8.getBizCommonParams() == null) goto L14;
        Iterator r2 = r8.getBizCommonParams().entrySet().iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        Map.Entry r3 = (Map.Entry) r2.next();
        this.b.a((String) r3.getKey(), (String) r3.getValue());
    L14:
        tt5.a.b("AtFinderHandler", "AtFinderHandler.handle data=" + r8.toString());
        this.a = r7;
        if (r8.getShow() != 1) goto L17;
        this.c.setActive(true);
    L17:
        this.c.setAtFinderLiveData(r8);
        return;
    L18:
        tt5.a.d("AtFinderHandler", "AtFinderHandler.handle:46 data or callback is null");
    }
}
