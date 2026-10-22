package com.ss.android.lark.bottomsheet.statistics;

import com.ss.android.lark.statistics.Statistics;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import org.json.JSONObject;
import r27.a;
import s5c.d;

/* JADX INFO: loaded from: classes34.dex */
public final class BottomSheetBizHitPoint {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/bottomsheet/statistics/BottomSheetBizHitPoint$ClickExtend;", "Lcom/ss/android/lark/statistics/extensions/IClickParam;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "EXPAND_HALF_SCREEN", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ClickExtend extends Enum<ClickExtend> implements d {
        public static final ClickExtend EXPAND_HALF_SCREEN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ClickExtend[] f410726a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f410727b = null;
        private final String value;

        public static EnumEntries<ClickExtend> getEntries() {
            return f410727b;
        }

        @Override // s5c.d
        public String getKey() {
            return "click";
        }

        static {
            ClickExtend r100 = new ClickExtend();
            EXPAND_HALF_SCREEN = r100;
            ClickExtend[] r101 = {r100};
            f410726a = r101;
            f410727b = EnumEntriesKt.enumEntries(r101);
        }

        public ClickExtend() {
            super("EXPAND_HALF_SCREEN", 0);
            this.value = "expand_half_screen";
        }

        public static ClickExtend[] values() {
            return (ClickExtend[]) f410726a.clone();
        }

        @Override // s5c.d
        public JSONObject toJson() {
            return d.b.c(this);
        }

        @Override // s5c.d
        public String getValue() {
            return this.value;
        }

        public static ClickExtend valueOf(String r100) {
            return (ClickExtend) a.a(ClickExtend.class, r100);
        }

        @Override // s5c.d
        public d plus(Map<String, ? extends Object> r100) {
            return d.b.a(this, r100);
        }

        @Override // s5c.d
        public d plus(d r100) {
            return d.b.b(this, r100);
        }
    }

    static {
    }

    @JvmStatic
    public static final void a() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("if_cross_tenant", Boolean.FALSE);
        Statistics.sendEvent("public_push_detail_click", ClickExtend.EXPAND_HALF_SCREEN.plus(r100).toJson());
    }
}
