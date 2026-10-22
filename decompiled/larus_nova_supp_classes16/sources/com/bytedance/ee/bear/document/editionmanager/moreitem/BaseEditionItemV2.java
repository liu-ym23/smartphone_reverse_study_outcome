package com.bytedance.ee.bear.document.editionmanager.moreitem;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class BaseEditionItemV2 extends BaseMoreItem implements ITextMoreItem {
    protected final Activity mActivity;
    protected final c15.d mCallback;
    protected final DocumentPluginHost pluginHost;

    public class a implements c15.d {
        public final /* synthetic */ BaseEditionItemV2 a;

        public final void b() {
            BaseEditionItemV2 r0 = this.a;
            Toast.showSuccessText(r0.mActivity, r0.getSuccessText(), 0);
            this.a.success();
        }

        public a(BaseEditionItemV2 r1) {
            this.a = r1;
        }

        public final void a(int r4) {
            if (r4 != 900099011) goto L5;
            return;
        L5:
            String r0 = this.a.getFailureText();
            if (TextUtils.isEmpty(r0) == true) goto L8;
            Toast.showFailureText(this.a.mActivity, r0, 0);
        L8:
            this.a.failed(r4);
        }
    }

    public void failed(int r1) {
    }

    public abstract String getFailureText();

    public final /* synthetic */ MoreUiAction getMoreAction() {
        return ITextMoreItem.-CC.$default$getMoreAction(this);
    }

    public String getStateTips() {
        return "";
    }

    public abstract String getSuccessText();

    public String getUnableTips() {
        return "";
    }

    public /* synthetic */ boolean isEnable() {
        return ITextMoreItem.-CC.$default$isEnable(this);
    }

    public boolean needShowBadge() {
        return false;
    }

    public void onDisableClick() {
    }

    public void success() {
    }

    public z05.g getCurrEditionMetadata() {
        BearUrl r0 = this.pluginHost.a().getBearUrl();
        return z05.f.c(r0.b, r0.n);
    }

    public BaseEditionItemV2(Activity r1, DocumentPluginHost r2) {
        this.mActivity = r1;
        this.pluginHost = r2;
        this.mCallback = new a(this);
    }
}
