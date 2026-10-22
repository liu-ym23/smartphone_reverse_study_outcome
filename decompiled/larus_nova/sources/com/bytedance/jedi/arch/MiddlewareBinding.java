package com.bytedance.jedi.arch;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.jedi.arch.JediViewModel;
import com.bytedance.jedi.arch.State;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0001H&¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/jedi/arch/MiddlewareBinding;", ExifInterface.LATITUDE_SOUTH, "Lcom/bytedance/jedi/arch/State;", "VM", "Lcom/bytedance/jedi/arch/JediViewModel;", "", "binding", "", PickerReporterConstants.KEY.TARGET, "(Lcom/bytedance/jedi/arch/JediViewModel;)V", "arch_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface MiddlewareBinding<S extends State, VM extends JediViewModel<S>> {
    void binding(VM r100);
}
