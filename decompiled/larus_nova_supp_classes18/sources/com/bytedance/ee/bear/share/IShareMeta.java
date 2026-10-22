package com.bytedance.ee.bear.share;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tH&J\b\u0010\u000e\u001a\u00020\u0007H&J\b\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0007H&J\b\u0010\u0013\u001a\u00020\u0007H&J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0007H&J\b\u0010\u0016\u001a\u00020\u0003H&J\b\u0010\u0017\u001a\u00020\u0003H&¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/share/IShareMeta;", "Ljava/io/Serializable;", "isOpen", "", "setFlag", "", "flag", "", "getShareToken", "", "setShareToken", "shareToken", "getRecordShareToken", "setRecordShareToken", "getObjType", "getShareType", "Lcom/bytedance/ee/bear/share/EShareType;", "setShareType", "shareType", "getSubmitFrequencyLimit", "setSubmitFrequencyLimit", "limit", "enableAnonymousSubmit", "isConstraintExternal", "Companion", "docs-bitable-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IShareMeta extends Serializable {
    public static final a Companion = null;
    public static final int FLAG_CLOSE = 0;
    public static final int FLAG_OPEN = 1;
    public static final int SUBMIT_UNLIMITED = 0;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.a;
    }

    boolean enableAnonymousSubmit();

    int getObjType();

    String getRecordShareToken();

    String getShareToken();

    EShareType getShareType();

    int getSubmitFrequencyLimit();

    boolean isConstraintExternal();

    boolean isOpen();

    void setFlag(int r1);

    void setRecordShareToken(String r1);

    void setShareToken(String r1);

    void setShareType(int r1);

    void setSubmitFrequencyLimit(int r1);
}
