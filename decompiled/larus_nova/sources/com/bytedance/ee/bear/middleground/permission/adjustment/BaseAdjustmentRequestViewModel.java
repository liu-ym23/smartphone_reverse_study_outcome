package com.bytedance.ee.bear.middleground.permission.adjustment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.middleground.permission.escape.model.Reviewer;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import ig5.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0010B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000bH&J\b\u0010\u000f\u001a\u00020\u000bH\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/adjustment/BaseAdjustmentRequestViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/ee/bear/middleground/permission/adjustment/IAdjustRequestInfo;", "<init>", "()V", "status", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/middleground/permission/adjustment/BaseAdjustmentRequestViewModel$AdjustmentStatus;", "getStatus", "()Landroidx/lifecycle/MutableLiveData;", "confirm", "", "reason", "", "cancel", WidgetCostModule.TYPE_ON_CREATE, "AdjustmentStatus", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseAdjustmentRequestViewModel extends ViewModel implements b {
    private final MutableLiveData<AdjustmentStatus> status;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/adjustment/BaseAdjustmentRequestViewModel$AdjustmentStatus;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "ADJUSTING", "ADJUST_SUCCESS", "ADJUST_FAILED", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AdjustmentStatus extends Enum<AdjustmentStatus> {
        public static final AdjustmentStatus ADJUSTING = null;
        public static final AdjustmentStatus ADJUST_FAILED = null;
        public static final AdjustmentStatus ADJUST_SUCCESS = null;
        public static final AdjustmentStatus NORMAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AdjustmentStatus[] f232862a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f232863b = null;

        public static EnumEntries<AdjustmentStatus> getEntries() {
            return f232863b;
        }

        static {
            AdjustmentStatus r100 = new AdjustmentStatus(EffectConstants.NORMAL, 0);
            NORMAL = r100;
            AdjustmentStatus r101 = new AdjustmentStatus("ADJUSTING", 1);
            ADJUSTING = r101;
            AdjustmentStatus r102 = new AdjustmentStatus("ADJUST_SUCCESS", 2);
            ADJUST_SUCCESS = r102;
            AdjustmentStatus r103 = new AdjustmentStatus("ADJUST_FAILED", 3);
            ADJUST_FAILED = r103;
            AdjustmentStatus[] r104 = {r100, r101, r102, r103};
            f232862a = r104;
            f232863b = EnumEntriesKt.enumEntries(r104);
        }

        public static AdjustmentStatus[] values() {
            return (AdjustmentStatus[]) f232862a.clone();
        }

        public static AdjustmentStatus valueOf(String r100) {
            return (AdjustmentStatus) a.a(AdjustmentStatus.class, r100);
        }

        public AdjustmentStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public abstract void cancel();

    public abstract void confirm(String r100);

    public abstract /* synthetic */ String getDescription();

    public abstract /* synthetic */ String getFailedToast();

    public abstract /* synthetic */ String getInputHint();

    public abstract /* synthetic */ String getLoadingToast();

    public abstract /* synthetic */ List<Reviewer> getReviewers();

    public abstract /* synthetic */ String getSuccessToast();

    public abstract /* synthetic */ String getTitle();

    public abstract /* synthetic */ String getToken();

    @Override // ig5.b
    public abstract /* synthetic */ int getType();

    public void onCreate() {
    }

    public abstract /* synthetic */ void setDescription(String r100);

    public abstract /* synthetic */ void setFailedToast(String r100);

    public abstract /* synthetic */ void setInputHint(String r100);

    public abstract /* synthetic */ void setLoadingToast(String r100);

    public abstract /* synthetic */ void setReviewers(List<Reviewer> r100);

    public abstract /* synthetic */ void setSuccessToast(String r100);

    public abstract /* synthetic */ void setTitle(String r100);

    public abstract /* synthetic */ void setToken(String r100);

    public abstract /* synthetic */ void setType(int r100);

    public BaseAdjustmentRequestViewModel() {
        this.status = new MutableLiveData(AdjustmentStatus.NORMAL);
    }

    public final MutableLiveData<AdjustmentStatus> getStatus() {
        return this.status;
    }
}
