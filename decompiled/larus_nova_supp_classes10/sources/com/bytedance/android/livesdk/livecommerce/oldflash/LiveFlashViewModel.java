package com.bytedance.android.livesdk.livecommerce.oldflash;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.base.ECBaseViewModel;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.FlashController;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u009d\u0001\u0010\u0017\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u001a\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J¾\u0001\u0010&\u001a\u00020\u00162\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u001a\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r\u0018\u00010\f2\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r0\f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010\u00022\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r2\u0006\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u0002J\u001a\u0010)\u001a\u00020\u00162\b\u0010'\u001a\u0004\u0018\u00010\u00022\b\u0010(\u001a\u0004\u0018\u00010\u0002J\b\u0010*\u001a\u0004\u0018\u00010\u0002J\b\u0010+\u001a\u0004\u0018\u00010\u0002J\b\u0010,\u001a\u0004\u0018\u00010\u0002J\b\u0010-\u001a\u0004\u0018\u00010\u0002J\b\u0010.\u001a\u0004\u0018\u00010\u0002J\b\u0010/\u001a\u0004\u0018\u00010\u0002J\u001a\u00100\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r\u0018\u00010\fJ\b\u00101\u001a\u0004\u0018\u00010\u0002J\b\u00102\u001a\u0004\u0018\u00010\u0002J\u000e\u00103\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0002J$\u00105\u001a\u00020\u00162\b\u00104\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u0006\u00106\u001a\u00020\u0002J\u0006\u00107\u001a\u00020\u0010J\u0006\u00108\u001a\u00020\u0012J\u0006\u00109\u001a\u00020\u0016J\u000e\u0010;\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\u0012J\u0012\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020=0<J\u001b\u0010@\u001a\u00020\u00162\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00020=¢\u0006\u0004\b@\u0010AR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010BR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010BR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010BR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010BR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010BR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010CR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010BR*\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010DR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010ER\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010FR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010BR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010BR\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0015\u0010GR\"\u0010H\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010E\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010L\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010E\u001a\u0004\bM\u0010I\"\u0004\bN\u0010KR$\u0010P\u001a\u0004\u0018\u00010O8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010V\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010E\u001a\u0004\bW\u0010I\"\u0004\bX\u0010KR\"\u0010Y\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010E\u001a\u0004\bZ\u0010I\"\u0004\b[\u0010KR$\u0010]\u001a\u0004\u0018\u00010\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR)\u0010i\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020d\u0018\u00010\r0c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR!\u0010m\u001a\b\u0012\u0004\u0012\u00020j0c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bk\u0010f\u001a\u0004\bl\u0010hR#\u0010q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010n0c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bo\u0010f\u001a\u0004\bp\u0010hR!\u0010t\u001a\b\u0012\u0004\u0012\u00020d0c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\br\u0010f\u001a\u0004\bs\u0010hR1\u0010y\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010v0u0c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bw\u0010f\u001a\u0004\bx\u0010hR!\u0010}\u001a\b\u0012\u0004\u0012\u00020z0c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b{\u0010f\u001a\u0004\b|\u0010hR$\u0010\u0080\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b~\u0010f\u001a\u0004\b\u007f\u0010hR*\u0010\u0083\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020=0c8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0081\u0001\u0010f\u001a\u0005\b\u0082\u0001\u0010h¨\u0006\u0086\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/oldflash/LiveFlashViewModel;", "Lcom/bytedance/android/livesdk/livecommerce/base/ECBaseViewModel;", "", "broadcastId", "broadcastSecId", "roomId", "targetId", "categoryNames", "categoryIds", "", "clickTime", "shopId", "", "", "propertiesMulti", "targetName", "", "needBarCode", "", "barCodeState", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/FlashController;", "flashController", "", "init", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/FlashController;)V", "name", "cover", "stock", "price", "note", "propertiesForRequest", "lastPropertiesMulti", "barCodeInfo", "stockReduction", "depositOption", "privilegeCodeList", "deliveryDelayTime", "supplyDayReturnCode", "buildFlashPromotion", "names", "ids", "setCategory", "getRoomId", "getAnchorId", "getCategoryIds", "getCategoryId", "getCategoryNames", "getShopId", "getProperties", "getTargetId", "getTargetName", "setTargetName", "categoryId", "loadProperties", "getProductType", "isNeedBarCode", "getBarCodeState", "genBarCode", "position", "checkIsBarCodeItem", "Landroidx/lifecycle/LiveData;", "", "getAlertDialogMessage", "messages", "postAlertDialogMessage", "([Ljava/lang/String;)V", "Ljava/lang/String;", "J", "Ljava/util/Map;", "Z", "I", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/FlashController;", "isCategoryChanged", "()Z", "setCategoryChanged", "(Z)V", "showErrorLine", "getShowErrorLine", "setShowErrorLine", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/q;", "eventHelper", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/q;", "getEventHelper", "()Lcom/bytedance/android/livesdk/livecommerce/oldflash/q;", "setEventHelper", "(Lcom/bytedance/android/livesdk/livecommerce/oldflash/q;)V", "hasLogShowSku", "getHasLogShowSku", "setHasLogShowSku", "canLogShowSku", "getCanLogShowSku", "setCanLogShowSku", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/s;", "flashHelper", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/s;", "getFlashHelper", "()Lcom/bytedance/android/livesdk/livecommerce/oldflash/s;", "setFlashHelper", "(Lcom/bytedance/android/livesdk/livecommerce/oldflash/s;)V", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/b;", "flashItemList$delegate", "Lkotlin/Lazy;", "getFlashItemList", "()Landroidx/lifecycle/MutableLiveData;", "flashItemList", "Ljava/lang/Void;", "flashSuccessObserver$delegate", "getFlashSuccessObserver", "flashSuccessObserver", "Lxi2/o;", "flashFailObserver$delegate", "getFlashFailObserver", "flashFailObserver", "itemClickObserver$delegate", "getItemClickObserver", "itemClickObserver", "Lkotlin/Pair;", "Lxi2/v;", "propertyLoadObserver$delegate", "getPropertyLoadObserver", "propertyLoadObserver", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/a;", "barCodeClickObserver$delegate", "getBarCodeClickObserver", "barCodeClickObserver", "barCodeLoadObserver$delegate", "getBarCodeLoadObserver", "barCodeLoadObserver", "alertDialogMessages$delegate", "getAlertDialogMessages", "alertDialogMessages", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFlashViewModel extends ECBaseViewModel {
    private final Lazy alertDialogMessages$delegate;
    private final Lazy barCodeClickObserver$delegate;
    private final Lazy barCodeLoadObserver$delegate;
    private int barCodeState;
    private String broadcastId;
    private String broadcastSecId;
    private boolean canLogShowSku;
    private String categoryIds;
    private String categoryNames;
    private long clickTime;
    private q eventHelper;
    private FlashController flashController;
    private final Lazy flashFailObserver$delegate;
    private s flashHelper;
    private final Lazy flashItemList$delegate;
    private final Lazy flashSuccessObserver$delegate;
    private boolean hasLogShowSku;
    private boolean isCategoryChanged;
    private final Lazy itemClickObserver$delegate;
    private boolean needBarCode;
    private Map<String, ? extends List<String>> propertiesMulti;
    private final Lazy propertyLoadObserver$delegate;
    private String roomId;
    private String shopId;
    private boolean showErrorLine;
    private String targetId;
    private String targetName;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ LiveFlashViewModel a;
        public final /* synthetic */ String[] b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ int d;

        public a(LiveFlashViewModel r1, String[] r2, Map r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r13) {
            xi2.o r14 = (xi2.o) r13;
            if (r14 != null) goto L5;
        L23:
            this.a.getFlashFailObserver().postValue(r14);
            return;
        L5:
            if (((com.bytedance.android.ec.model.g) r14).statusCode != 0) goto L23;
            this.a.getFlashSuccessObserver().postValue(null);
            q r15 = this.a.getEventHelper();
            if (r15 == null) goto L9;
            new com.bytedance.android.livesdk.livecommerce.event.c0(r15.a, r15.b, r15.c).k();
        L9:
            q r16 = this.a.getEventHelper();
            if (r16 == null) goto L20;
            long r0 = LiveFlashViewModel.access$getClickTime$p(this.a);
            String[] r2 = this.b;
            if (r2 == null) goto L18;
            boolean r4 = false;
            if (r2.length != 0) goto L16;
            boolean r3 = true;
        L17:
            if (r3 == true) goto L18;
        L19:
            new com.bytedance.android.livesdk.livecommerce.event.w(r16.a, r16.b, System.currentTimeMillis() - r0, r16.c, !r4).k();
            goto L20
        L16:
            r3 = false;
        L18:
            r4 = true;
        L20:
            FlashController r17 = LiveFlashViewModel.access$getFlashController$p(this.a);
            String r1 = LiveFlashViewModel.access$getCategoryNames$p(this.a);
            String r5 = LiveFlashViewModel.access$getCategoryIds$p(this.a);
            Map<String, ? extends List<String>> r6 = this.c;
            int r7 = this.d;
            FlashController.b r18 = r17.e;
            if (r18 == null) goto L25;
            r18.d = r1;
            r18.e = r5;
            r18.g = r6;
            r18.b = r7;
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LiveFlashViewModel a;

        public b(LiveFlashViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            this.a.getFlashFailObserver().postValue(null);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LiveFlashViewModel a;

        public c(LiveFlashViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            xi2.t r4 = (xi2.t) r3;
            String r0 = null;
            if (r4 != null) goto L5;
        L10:
            this.a.getBarCodeLoadObserver().postValue(null);
            return;
        L5:
            if (((com.bytedance.android.ec.model.g) r4).statusCode != 0) goto L10;
            MutableLiveData<String> r1 = this.a.getBarCodeLoadObserver();
            List<String> r5 = r4.a();
            if (r5 == null) goto L9;
            r0 = (String) CollectionsKt.firstOrNull(r5);
        L9:
            r1.postValue(r0);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ LiveFlashViewModel a;

        public d(LiveFlashViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            this.a.getBarCodeLoadObserver().postValue(null);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ LiveFlashViewModel a;
        public final /* synthetic */ String b;

        public e(LiveFlashViewModel r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            xi2.v r5 = (xi2.v) r4;
            if (r5 != null) goto L5;
        L7:
            this.a.getPropertyLoadObserver().postValue(null);
            return;
        L5:
            if (((com.bytedance.android.ec.model.g) r5).statusCode != 0) goto L7;
            this.a.getPropertyLoadObserver().postValue(new Pair(this.b, r5));
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ LiveFlashViewModel a;

        public f(LiveFlashViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            this.a.getPropertyLoadObserver().postValue(null);
        }
    }

    private final MutableLiveData<String[]> getAlertDialogMessages() {
        return (MutableLiveData) this.alertDialogMessages$delegate.getValue();
    }

    public final MutableLiveData<com.bytedance.android.livesdk.livecommerce.oldflash.a> getBarCodeClickObserver() {
        return (MutableLiveData) this.barCodeClickObserver$delegate.getValue();
    }

    public final MutableLiveData<String> getBarCodeLoadObserver() {
        return (MutableLiveData) this.barCodeLoadObserver$delegate.getValue();
    }

    public final MutableLiveData<xi2.o> getFlashFailObserver() {
        return (MutableLiveData) this.flashFailObserver$delegate.getValue();
    }

    public final MutableLiveData<List<com.bytedance.android.livesdk.livecommerce.oldflash.b>> getFlashItemList() {
        return (MutableLiveData) this.flashItemList$delegate.getValue();
    }

    public final MutableLiveData<Void> getFlashSuccessObserver() {
        return (MutableLiveData) this.flashSuccessObserver$delegate.getValue();
    }

    public final MutableLiveData<com.bytedance.android.livesdk.livecommerce.oldflash.b> getItemClickObserver() {
        return (MutableLiveData) this.itemClickObserver$delegate.getValue();
    }

    public final MutableLiveData<Pair<String, xi2.v>> getPropertyLoadObserver() {
        return (MutableLiveData) this.propertyLoadObserver$delegate.getValue();
    }

    public final void genBarCode() {
        String r0 = vi2.h.a;
        nl2.b.b(vi2.h.e(null, null, si2.g.K, new vi2.g0()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), new d(this)));
    }

    public final String getCategoryId() {
        String r0 = this.categoryIds;
        if (r0 == null) goto L7;
        List r1 = StringsKt.split$default(r0, new String[]{","}, false, 0, 6, null);
        if (r1 == null) goto L7;
        return (String) CollectionsKt.lastOrNull(r1);
    L7:
        return null;
    }

    public final String getProductType() {
        String r0 = this.targetId;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return "buynow_all";
    L11:
        return "buynow_part";
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public LiveFlashViewModel() {
        this.broadcastId = "";
        this.broadcastSecId = "";
        this.roomId = "";
        this.categoryIds = "";
        this.categoryNames = "";
        this.shopId = "";
        this.targetId = "";
        this.targetName = "";
        this.canLogShowSku = true;
        this.flashItemList$delegate = LazyKt.lazy(LiveFlashViewModel$flashItemList$2.INSTANCE);
        this.flashSuccessObserver$delegate = LazyKt.lazy(LiveFlashViewModel$flashSuccessObserver$2.INSTANCE);
        this.flashFailObserver$delegate = LazyKt.lazy(LiveFlashViewModel$flashFailObserver$2.INSTANCE);
        this.itemClickObserver$delegate = LazyKt.lazy(LiveFlashViewModel$itemClickObserver$2.INSTANCE);
        this.propertyLoadObserver$delegate = LazyKt.lazy(LiveFlashViewModel$propertyLoadObserver$2.INSTANCE);
        this.barCodeClickObserver$delegate = LazyKt.lazy(LiveFlashViewModel$barCodeClickObserver$2.INSTANCE);
        this.barCodeLoadObserver$delegate = LazyKt.lazy(LiveFlashViewModel$barCodeLoadObserver$2.INSTANCE);
        this.alertDialogMessages$delegate = LazyKt.lazy(LiveFlashViewModel$alertDialogMessages$2.INSTANCE);
    }

    public final LiveData<String[]> getAlertDialogMessage() {
        return getAlertDialogMessages();
    }

    public final String getAnchorId() {
        return this.broadcastId;
    }

    public final int getBarCodeState() {
        return this.barCodeState;
    }

    public final boolean getCanLogShowSku() {
        return this.canLogShowSku;
    }

    public final String getCategoryIds() {
        return this.categoryIds;
    }

    public final String getCategoryNames() {
        return this.categoryNames;
    }

    public final q getEventHelper() {
        return this.eventHelper;
    }

    public final s getFlashHelper() {
        return this.flashHelper;
    }

    public final boolean getHasLogShowSku() {
        return this.hasLogShowSku;
    }

    public final Map<String, List<String>> getProperties() {
        return this.propertiesMulti;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final boolean getShowErrorLine() {
        return this.showErrorLine;
    }

    public final String getTargetId() {
        return this.targetId;
    }

    public final String getTargetName() {
        return this.targetName;
    }

    public final boolean isCategoryChanged() {
        return this.isCategoryChanged;
    }

    public final boolean isNeedBarCode() {
        return this.needBarCode;
    }

    public static final /* synthetic */ String access$getCategoryIds$p(LiveFlashViewModel r0) {
        return r0.categoryIds;
    }

    public static final /* synthetic */ String access$getCategoryNames$p(LiveFlashViewModel r0) {
        return r0.categoryNames;
    }

    public static final /* synthetic */ long access$getClickTime$p(LiveFlashViewModel r2) {
        return r2.clickTime;
    }

    public static final /* synthetic */ FlashController access$getFlashController$p(LiveFlashViewModel r1) {
        FlashController r2 = r1.flashController;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("flashController");
    L5:
        return r2;
    }

    public final boolean checkIsBarCodeItem(int r4) {
        List r0 = (List) getFlashItemList().getValue();
        if (r0 == null) goto L16;
        int r2 = r0.size();
        if (r4 < 0) goto L19;
        if (r2 <= r4) goto L17;
        com.bytedance.android.livesdk.livecommerce.oldflash.b r5 = (com.bytedance.android.livesdk.livecommerce.oldflash.b) ListProtector.get(r0, r4);
        s r1 = this.flashHelper;
        if (r1 == null) goto L11;
        com.bytedance.android.livesdk.livecommerce.oldflash.a r3 = r1.h;
    L13:
        if (Intrinsics.areEqual(r5, r3) == false) goto L18;
        return true;
    L18:
        return false;
    L11:
        r3 = null;
        goto L13
    L17:
        return false;
    L19:
        return false;
    L16:
        return false;
    }

    public final void postAlertDialogMessage(String[] r2) {
        Intrinsics.checkNotNullParameter(r2, "messages");
        getAlertDialogMessages().postValue(r2);
    }

    public final void setCanLogShowSku(boolean r1) {
        this.canLogShowSku = r1;
    }

    public final void setCategoryChanged(boolean r1) {
        this.isCategoryChanged = r1;
    }

    public final void setEventHelper(q r1) {
        this.eventHelper = r1;
    }

    public final void setFlashHelper(s r1) {
        this.flashHelper = r1;
    }

    public final void setHasLogShowSku(boolean r1) {
        this.hasLogShowSku = r1;
    }

    public final void setShowErrorLine(boolean r1) {
        this.showErrorLine = r1;
    }

    public final void setTargetName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        this.targetName = r2;
    }

    public static final /* synthetic */ void access$setCategoryIds$p(LiveFlashViewModel r0, String r1) {
        r0.categoryIds = r1;
    }

    public static final /* synthetic */ void access$setCategoryNames$p(LiveFlashViewModel r0, String r1) {
        r0.categoryNames = r1;
    }

    public static final /* synthetic */ void access$setClickTime$p(LiveFlashViewModel r0, long r1) {
        r0.clickTime = r1;
    }

    public static final /* synthetic */ void access$setFlashController$p(LiveFlashViewModel r0, FlashController r1) {
        r0.flashController = r1;
    }

    public final void setCategory(String r3, String r4) {
        if ((!Intrinsics.areEqual(r4, this.categoryIds)) == false) goto L5;
        this.isCategoryChanged = true;
    L5:
        this.categoryNames = r3;
        this.categoryIds = r4;
    }

    public final void loadProperties(String r3, String r4, String r5) {
        String r0 = vi2.h.a;
        String r1 = vi2.h.d(si2.g.H);
        nl2.b.b(vi2.h.e(null, null, r1, new vi2.f0(r3, r4, r5, r1)).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this, r3), new f(this)));
    }

    public final void init(String r2, String r3, String r4, String r5, String r6, String r7, long r8, String r10, Map<String, ? extends List<String>> r11, String r12, Boolean r13, Integer r14, FlashController r15) {
        Intrinsics.checkNotNullParameter(r15, "flashController");
        this.broadcastId = r2;
        this.broadcastSecId = r3;
        this.roomId = r4;
        this.targetId = r5;
        this.categoryIds = r7;
        this.categoryNames = r6;
        this.clickTime = r8;
        this.shopId = r10;
        this.propertiesMulti = r11;
        this.targetName = r12;
        this.eventHelper = new q(r2, r4, getProductType());
        int r9 = 0;
        if (r13 == null) goto L5;
        boolean r16 = r13.booleanValue();
    L6:
        this.needBarCode = r16;
        if (r14 == null) goto L9;
        r9 = r14.intValue();
    L9:
        this.barCodeState = r9;
        if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L13;
        if (r15 != null) goto L14;
        int r17 = FlashController.f;
        r15 = ControllerCenter.c(null, null).p;
        Objects.toString(r15);
    L14:
        this.flashController = r15;
        return;
    L13:
        int r18 = FlashController.f;
        r15 = ControllerCenter.c(r4, null).p;
        Objects.toString(r15);
        goto L14
    L5:
        r16 = false;
        goto L6
    }

    public final void buildFlashPromotion(String r25, String r26, String r27, int r28, int r29, String r30, Map<String, ? extends List<String>> r31, Map<String, ? extends List<String>> r32, List<String> r33, int r34, int r35, String r36, List<String> r37, long r38, String r40) {
        Intrinsics.checkNotNullParameter(r32, "lastPropertiesMulti");
        Intrinsics.checkNotNullParameter(r33, "barCodeInfo");
        if (r37 == null) goto L9;
        Object[] r2 = r37.toArray(new String[0]);
        if (r2 == null) goto L8;
        String[] r3 = (String[]) r2;
    L10:
        FlashController r4 = this.flashController;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("flashController");
    L13:
        String r15 = r4.D();
        String r5 = this.targetId;
        String r7 = String.valueOf(r28);
        String r8 = String.valueOf(r29);
        String r10 = this.categoryIds;
        String r13 = GsonProtectorUtils.toJson(new Gson(), r31);
        String r6 = (String) CollectionsKt.firstOrNull(r33);
        if (r6 != null) goto L16;
        r6 = "";
    L16:
        String r14 = r6;
        String r16 = String.valueOf(r34);
        String r9 = vi2.h.a;
        String r12 = vi2.h.d(si2.g.G);
        nl2.b.b(vi2.h.e(r25, r15, r12, new vi2.a0(r26, r5, r27, r7, r8, r30, r10, r25, r15, r13, r14, r16, r38, r40, r35, r36, r3, r12)).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, r3, r32, r34), new b(this)));
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L9:
        r3 = null;
        goto L10
    }
}
