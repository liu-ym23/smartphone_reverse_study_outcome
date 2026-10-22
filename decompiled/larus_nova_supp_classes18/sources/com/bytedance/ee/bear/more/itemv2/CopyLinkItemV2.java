package com.bytedance.ee.bear.more.itemv2;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.supervisor.token.Token;
import java.util.HashMap;
import oj5.c;
import oj5.f;
import s45.p;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class CopyLinkItemV2 extends BaseMoreItem implements ITextMoreItem {
    private static final String SET_PRIMARY_CLIP_TOKEN = "LARK-PSDA-ccm_android_more_dialog_copy_link";
    private static final String TAG = "CopyLinkItemV2";
    private String mModule;
    private String mSource;

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return 2131255013;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return 2131102418;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public final /* synthetic */ MoreUiAction getMoreAction() {
        return ITextMoreItem.CC.$default$getMoreAction(this);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getStateTips() {
        return "";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getUnableTips() {
        return "";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean isEnable() {
        return true;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        return true;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean needShowBadge() {
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onDisableClick() {
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return CommonMoreItemId.COPY_LINK.getId();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return getString(2131889020);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onClick() {
        Context r0 = getHost().getHostFragment().getContext();
        c r1 = getMoreInfo();
        if (r1 != null) goto L6;
    L7:
        String r2 = null;
    L9:
        if (r2 == null) goto L14;
        if (r0 == null) goto L12;
        Toast.showFailureText(r0, r2, 0);
    L12:
        tt5.a.h(TAG, "block disabled copy link operation.");
        return;
    L14:
        onCopyLinkClicked(r0, r1);
        getHost().a();
        return;
    L6:
        if (r1.M() == null) goto L7;
        r2 = r1.M().get(getId());
        goto L9
    }

    public CopyLinkItemV2(String r1, String r2) {
        this.mSource = r1;
        this.mModule = r2;
    }

    private boolean copyLink(Context r4, c r5) {
        String r6 = r5.getContainerUrl();
        if (r6 != null) goto L13;
    L12:
        return false;
    L13:
        String r7 = UriProtector.parse(r6).buildUpon().clearQuery().toString();     // Catch: Exception -> L7
        if (r5.o() == false) goto L9;
        BearUrl r8 = p.a().Z(r7);     // Catch: Exception -> L7
        r7 = UriProtector.parse(r7).buildUpon().path(p.a().j8(r8.getType(), r8.b)).toString();     // Catch: Exception -> L7
    L9:
        return ((fu5.a) org.koin.java.a.a(fu5.a.class)).n(r7, false, new Token(SET_PRIMARY_CLIP_TOKEN));
    L7:
        e = move-exception;
        tt5.a.f(TAG, e, false);
        goto L12
    }

    private void onCopyLinkClicked(Context r19, c r20) {
        if (r20 == null) goto L30;
        if (r19 == null) goto L30;
        if (copyLink(r19, r20) == false) goto L9;
        Toast.showSuccessText(r19, 2131887728);
    L10:
        String r0 = this.mSource;
        String r3 = this.mModule;
        HashMap r6 = new HashMap();     // Catch: Throwable -> L21
        r6.put("source", r0);     // Catch: Throwable -> L21
        r6.put("file_id", du5.b.g(r20.getToken()));     // Catch: Throwable -> L21
        r6.put("file_type", e.c(r20.getType()));     // Catch: Throwable -> L21
        r6.put("action", "copy_link");     // Catch: Throwable -> L21
        r6.put("module", r3);     // Catch: Throwable -> L21
        if (r20.getType() != e.l.b) goto L17;
        if (TextUtils.isEmpty(r20.b()) == true) goto L17;
        r6.put("sub_file_type", r20.b());     // Catch: Throwable -> L21
    L17:
        if (TextUtils.isEmpty(r20.getAppId()) == true) goto L19;
        r6.put("appid", r20.getAppId());     // Catch: Throwable -> L21
    L19:
        tt5.a.b("MoreAnalytic", "more: reportMoreEvent, params = " + r6);     // Catch: Throwable -> L21
        ((d) org.koin.java.a.a(d.class)).v("client_content_management", r6);     // Catch: Throwable -> L21
    L24:
        if ((r20 instanceof oj5.b) == false) goto L27;
        oj5.b r1 = (oj5.b) r20;
        com.bytedance.ee.bear.more.c.c(new i(getHost().getHostFragment().getArguments(), r20.getToken(), r20.getType(), FolderVersion.isShareFolder(r1.o.getOwnerType(), r1.p), r20.b(), "copy_link", "none", "", "", false, false, r20.H(), r20.isOwner(), r20.L()));
        return;
    L27:
        if ((r20 instanceof oj5.a) == false) goto L35;
        com.bytedance.ee.bear.more.c.c(new i(getHost().getHostFragment().getArguments(), r20.getToken(), r20.getType(), false, r20.b(), "copy_link", "none", "", "", r20 instanceof f, ((oj5.a) r20).k, r20.H(), r20.isOwner(), r20.L()));
        return;
    L35:
        return;
    L21:
        th = move-exception;
        tt5.a.e("MoreAnalytic", "reportCopyLinkEvent()...error", th, false);
        goto L24
    L9:
        Toast.showFailureText(r19, 2131887724);
    L30:
        tt5.a.d(TAG, "onCopyLinkClicked()..., more info or context== null");
    }
}
