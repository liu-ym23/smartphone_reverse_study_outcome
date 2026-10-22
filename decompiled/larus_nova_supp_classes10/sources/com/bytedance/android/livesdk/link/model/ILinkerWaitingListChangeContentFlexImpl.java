package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.im.LinkerWaitingListChangeContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R#\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkerWaitingListChangeContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/r6;", "", "version$delegate", "Ljava/lang/Object;", "getVersion", "()J", "version", "", "Lcom/bytedance/android/livesdk/link/model/IAnchorLinkUserExtensionImpl;", "linkUsers$delegate", "getLinkUsers", "()Ljava/util/List;", "linkUsers", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkerWaitingListChangeContentFlexImpl extends FlexModelBase<r6> implements r6, vh7.h {

    @SerializedName("list_users")
    protected List<IAnchorLinkUserExtensionImpl> _$$linkUsers;

    @SerializedName("version")
    protected long _$$version;

    public ILinkerWaitingListChangeContentFlexImpl() {
        super(r6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.r6
    public final List<IAnchorLinkUserExtensionImpl> getLinkUsers() {
        return this._$$linkUsers;
    }

    @Override // com.bytedance.android.livesdk.link.model.r6
    public final long getVersion() {
        return this._$$version;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, vh7.c] */
    public ILinkerWaitingListChangeContentFlexImpl(am3.g r6) {
        super(r6.class);
        this._$$linkUsers = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 3) goto L8;
        this._$$linkUsers.add((IAnchorLinkUserExtensionImpl) vh7.f.a(r6, com.bytedance.android.livesdk.link.model.bridge.k.class).castTo(IAnchorLinkUserExtensionImpl.class));
        goto L3
    L8:
        if (r2 != 4) goto L9;
        this._$$version = r6.j();
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
    }
}
