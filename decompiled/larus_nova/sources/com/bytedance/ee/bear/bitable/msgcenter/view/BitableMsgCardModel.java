package com.bytedance.ee.bear.bitable.msgcenter.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import androidx.core.content.ContextCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.util.io.NonProguard;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\tR\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u001c\u0010,\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010&\"\u0004\b.\u0010(R\u001c\u0010/\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010&\"\u0004\b1\u0010(R\u001c\u00102\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010&\"\u0004\b4\u0010(R\u001a\u00105\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0007\"\u0004\b7\u0010\t¨\u0006<"}, d2 = {"Lcom/bytedance/ee/bear/bitable/msgcenter/view/BitableMsgCardModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "avatar", "Lcom/bytedance/ee/bear/bitable/panel/Icon;", "getAvatar", "()Lcom/bytedance/ee/bear/bitable/panel/Icon;", "setAvatar", "(Lcom/bytedance/ee/bear/bitable/panel/Icon;)V", "title", "", "Lcom/bytedance/ee/bear/bitable/msgcenter/view/StringModel;", "getTitle", "()Ljava/util/List;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/util/List;)V", "time", "getTime", "setTime", "unread", "", "getUnread", "()Z", "setUnread", "(Z)V", "cardEntity", "getCardEntity", "setCardEntity", "clickAvatar", "Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "getClickAvatar", "()Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "setClickAvatar", "(Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;)V", "clickMessage", "getClickMessage", "setClickMessage", "toggleReadAction", "getToggleReadAction", "setToggleReadAction", "clickDelete", "getClickDelete", "setClickDelete", "readAction", "getReadAction", "setReadAction", GXTemplateKey.GAIAX_TEMPLATE_TYPE, "getTemplateType", "setTemplateType", "getTitleString", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableMsgCardModel implements NonProguard {
    private Icon avatar;
    private String cardEntity;
    private ActionPayload clickAvatar;
    private ActionPayload clickDelete;
    private ActionPayload clickMessage;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f214692id;
    private ActionPayload readAction;
    private String templateType;
    private String time;
    private List<StringModel> title;
    private ActionPayload toggleReadAction;
    private boolean unread;

    public BitableMsgCardModel() {
        this.f214692id = "";
        Icon r100 = new Icon();
        r100.setImgRes(Integer.valueOf(R.drawable.facade_common_avatar_place_holder));
        this.avatar = r100;
        this.title = new ArrayList();
        this.time = "";
        this.cardEntity = "";
        this.templateType = "";
    }

    public final Icon getAvatar() {
        return this.avatar;
    }

    public final String getCardEntity() {
        return this.cardEntity;
    }

    public final ActionPayload getClickAvatar() {
        return this.clickAvatar;
    }

    public final ActionPayload getClickDelete() {
        return this.clickDelete;
    }

    public final ActionPayload getClickMessage() {
        return this.clickMessage;
    }

    public final String getId() {
        return this.f214692id;
    }

    public final ActionPayload getReadAction() {
        return this.readAction;
    }

    public final String getTemplateType() {
        return this.templateType;
    }

    public final String getTime() {
        return this.time;
    }

    public final List<StringModel> getTitle() {
        return this.title;
    }

    public final ActionPayload getToggleReadAction() {
        return this.toggleReadAction;
    }

    public final boolean getUnread() {
        return this.unread;
    }

    public final CharSequence getTitleString(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        SpannableStringBuilder r101 = new SpannableStringBuilder();
        Iterator<T> r102 = this.title.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L20;
        StringModel r104 = (StringModel) r102.next();
        int r105 = r104.getText().length() + r103;
        Integer r106 = r104.getFontSize();
        if (r106 == null) goto L8;
        int r107 = r106.intValue();
    L9:
        Integer r108 = r104.getWeight();
        if (r108 == null) goto L12;
        int r109 = r108.intValue();
    L21:
        String r110 = r104.getColor();     // Catch: Exception -> L18
        if (r110 != null) goto L16;
        r110 = "text-title";
    L16:
        int r111 = ContextCompat.getColor(r100, UDColorUtils.getColorIdByToken(r100, r110));     // Catch: Exception -> L18
    L19:
        r101.append(r104.getText());
        r101.setSpan(new com.bytedance.ee.bear.bitable.e(r107, r111, r109), r103, r105, 33);
        r103 = r105;
    L18:
        r111 = ContextCompat.getColor(r100, R.color.text_title);
        goto L19
    L12:
        r109 = 500;
        goto L21
    L8:
        r107 = 14;
        goto L9
    L20:
        return r101;
    }

    public final void setAvatar(Icon r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.avatar = r100;
    }

    public final void setCardEntity(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cardEntity = r100;
    }

    public final void setClickAvatar(ActionPayload r100) {
        this.clickAvatar = r100;
    }

    public final void setClickDelete(ActionPayload r100) {
        this.clickDelete = r100;
    }

    public final void setClickMessage(ActionPayload r100) {
        this.clickMessage = r100;
    }

    public final void setId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f214692id = r100;
    }

    public final void setReadAction(ActionPayload r100) {
        this.readAction = r100;
    }

    public final void setTemplateType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.templateType = r100;
    }

    public final void setTime(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.time = r100;
    }

    public final void setTitle(List<StringModel> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.title = r100;
    }

    public final void setToggleReadAction(ActionPayload r100) {
        this.toggleReadAction = r100;
    }

    public final void setUnread(boolean r100) {
        this.unread = r100;
    }
}
