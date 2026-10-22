package com.bytedance.ee.bear.picker;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.picker.config.NavPickerConfig;
import com.ss.android.lark.picker.doubao.LarkPicker;
import com.ss.android.lark.picker.factory.PickerFactory;
import com.ss.android.lark.picker.factory.PickerViewHolder;
import com.ss.android.lark.picker.statistics.PickerStatistics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@ClaymoreImpl(PickerFactory.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/picker/OfficePickerFactory;", "Lcom/ss/android/lark/picker/factory/PickerFactory;", "<init>", "()V", "createNavPickerHolder", "Lcom/ss/android/lark/picker/factory/PickerViewHolder;", "activity", "Landroidx/fragment/app/FragmentActivity;", "config", "Lcom/ss/android/lark/picker/config/NavPickerConfig;", "scene", "Lcom/ss/android/lark/picker/statistics/PickerStatistics$Scene;", "assemble-office_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficePickerFactory implements PickerFactory {

    public static final class a implements PickerViewHolder {
        public final LarkPicker a;
        public final /* synthetic */ LarkPicker b;

        public final void destroy() {
            this.b.destroy();
        }

        public final View getView() {
            return this.a;
        }

        public a(LarkPicker r1) {
            this.b = r1;
            this.a = r1;
        }
    }

    public OfficePickerFactory() {
    }

    public PickerViewHolder createNavPickerHolder(FragmentActivity r3, NavPickerConfig r4, PickerStatistics.Scene r5) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r5, "scene");
        r4.extra(AnonymousClass1.INSTANCE);
        LarkPicker r6 = new LarkPicker(r3, null, 2, null);
        r6.init(r3, r4);
        return new a(r6);
    }
}
