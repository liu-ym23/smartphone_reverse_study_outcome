package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.battle.Area")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\"\u0010#R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\r\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\u0004\u0018\u00010\u001d8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPanelAreaFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/IPanelArea;", "", "uiType$delegate", "Ljava/lang/Object;", "getUiType", "()Ljava/lang/Integer;", "uiType", "Lcom/bytedance/android/livesdk/link/model/ITitleAreaFlexImpl;", "title$delegate", "getTitle", "()Lcom/bytedance/android/livesdk/link/model/ITitleAreaFlexImpl;", "title", "Lcom/bytedance/android/livesdk/link/model/IRivalsAreaFlexImpl;", "rivals$delegate", "getRivals", "()Lcom/bytedance/android/livesdk/link/model/IRivalsAreaFlexImpl;", "rivals", "Lcom/bytedance/android/livesdk/link/model/IContentAreaFlexImpl;", "content$delegate", "getContent", "()Lcom/bytedance/android/livesdk/link/model/IContentAreaFlexImpl;", "content", "Lcom/bytedance/android/livesdk/link/model/IUserListAreaFlexImpl;", "userList$delegate", "getUserList", "()Lcom/bytedance/android/livesdk/link/model/IUserListAreaFlexImpl;", "userList", "Lcom/bytedance/android/livesdk/link/model/IPKRecordListAreaFlexImpl;", "recordList$delegate", "getRecordList", "()Lcom/bytedance/android/livesdk/link/model/IPKRecordListAreaFlexImpl;", "recordList", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IPanelAreaFlexImpl extends FlexModelBase<IPanelArea> implements IPanelArea, vh7.h {

    @SerializedName("content_area")
    protected IContentAreaFlexImpl _$$content;

    @SerializedName("pk_record_list_area")
    protected IPKRecordListAreaFlexImpl _$$recordList;

    @SerializedName("rivals_area")
    protected IRivalsAreaFlexImpl _$$rivals;

    @SerializedName("title_area")
    protected ITitleAreaFlexImpl _$$title;

    @SerializedName("ui_type")
    protected Integer _$$uiType;

    @SerializedName("user_list_area")
    protected IUserListAreaFlexImpl _$$userList;

    public IPanelAreaFlexImpl() {
        super(IPanelArea.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IPanelArea
    public /* bridge */ /* synthetic */ a4 getContent() {
        return getContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.IPanelArea
    public /* bridge */ /* synthetic */ l7 getRecordList() {
        return getRecordList();
    }

    @Override // com.bytedance.android.livesdk.link.model.IPanelArea
    public /* bridge */ /* synthetic */ t8 getRivals() {
        return getRivals();
    }

    @Override // com.bytedance.android.livesdk.link.model.IPanelArea
    public /* bridge */ /* synthetic */ v9 getTitle() {
        return getTitle();
    }

    @Override // com.bytedance.android.livesdk.link.model.IPanelArea
    public /* bridge */ /* synthetic */ z9 getUserList() {
        return getUserList();
    }

    @Override // com.bytedance.android.livesdk.link.model.IPanelArea
    public final Integer getUiType() {
        return this._$$uiType;
    }

    @Override // com.bytedance.android.livesdk.link.model.IPanelArea
    public final IContentAreaFlexImpl getContent() {
        return this._$$content;
    }

    @Override // com.bytedance.android.livesdk.link.model.IPanelArea
    public final IPKRecordListAreaFlexImpl getRecordList() {
        return this._$$recordList;
    }

    @Override // com.bytedance.android.livesdk.link.model.IPanelArea
    public final IRivalsAreaFlexImpl getRivals() {
        return this._$$rivals;
    }

    @Override // com.bytedance.android.livesdk.link.model.IPanelArea
    public final ITitleAreaFlexImpl getTitle() {
        return this._$$title;
    }

    @Override // com.bytedance.android.livesdk.link.model.IPanelArea
    public final IUserListAreaFlexImpl getUserList() {
        return this._$$userList;
    }

    public IPanelAreaFlexImpl(am3.g r5) {
        super(IPanelArea.class);
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L14;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this._$$recordList = new IPKRecordListAreaFlexImpl(r5);
        goto L3
    L9:
        this._$$userList = new IUserListAreaFlexImpl(r5);
        goto L3
    L10:
        this._$$rivals = new IRivalsAreaFlexImpl(r5);
        goto L3
    L11:
        this._$$content = new IContentAreaFlexImpl(r5);
        goto L3
    L12:
        this._$$title = new ITitleAreaFlexImpl(r5);
        goto L3
    L13:
        this._$$uiType = Integer.valueOf(r5.i());
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L14:
        r5.d(r0);
        setThreadSafe(true);
    }
}
