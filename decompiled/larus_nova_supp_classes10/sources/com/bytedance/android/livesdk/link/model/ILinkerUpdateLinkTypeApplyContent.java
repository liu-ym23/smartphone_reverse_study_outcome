package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0016R\u0014\u0010\u0006\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\u000e\u001a\u00020\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u000f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkerUpdateLinkTypeApplyContent;", "Lvh7/c;", "", "", "getFromUserIdString", "()Ljava/lang/String;", "fromUserIdString", "getToUserIdString", "toUserIdString", "getToast", "toast", "", "getShowType", "()J", "showType", "", "getClientNoToast", "()Ljava/lang/Boolean;", "setClientNoToast", "(Ljava/lang/Boolean;)V", "clientNoToast", "Companion", "a", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkerUpdateLinkTypeApplyContent extends vh7.c<ILinkerUpdateLinkTypeApplyContent> {
    public static final a Companion = null;
    public static final long InviteAndPreviewPanel = 0;
    public static final long OnlyPreviewPanel = 1;
    public static final int SOURCE_GAME = 2;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        Companion = a.a;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    /* synthetic */ String getAckMessage();

    Boolean getClientNoToast();

    String getFromUserIdString();

    /* synthetic */ int getLinkType();

    long getShowType();

    /* synthetic */ int getSource();

    String getToUserIdString();

    String getToast();

    void setClientNoToast(Boolean r1);
}
