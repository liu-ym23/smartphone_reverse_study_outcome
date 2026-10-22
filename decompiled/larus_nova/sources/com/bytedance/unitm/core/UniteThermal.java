package com.bytedance.unitm.core;

import android.content.Context;
import com.bytedance.unitm.api.IActionManager;
import com.bytedance.unitm.api.IThermalMitigation;
import com.bytedance.unitm.api.IThermalStatusDetailListener;
import com.bytedance.unitm.api.IThermalStatusManager;
import com.bytedance.unitm.api.SimpleThermalMitigation;
import com.bytedance.unitm.api.ThermalStatus;
import com.bytedance.unitm.util.TLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class UniteThermal {
    private static volatile UniteThermal mInstance;
    private IActionManager actionManager;
    private Context context;
    private UniteThermalStatusListener listener;
    private List<IThermalMitigation> thermalMitigationList;
    private IThermalStatusManager thermalStatusManager;

    public class UniteThermalStatusListener implements IThermalStatusDetailListener {
        private int lastStatus;
        final /* synthetic */ UniteThermal this$0;

        @Override // com.bytedance.unitm.api.IThermalStatusDetailListener
        public String getDescription() {
            return "Unite thermalListener";
        }

        public UniteThermalStatusListener(UniteThermal r100) {
            this.this$0 = r100;
            this.lastStatus = -1;
        }

        @Override // com.bytedance.unitm.api.IThermalStatusDetailListener
        public void onThermalStatusChanged(ThermalStatus r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (UniteThermal.access$000(this.this$0).isEmpty() == false) goto L6;
            return;
        L6:
            if (r100.status == this.lastStatus) goto L33;
            List r101 = UniteThermal.access$000(this.this$0);
            monitor-enter(r101);
            int r102 = r100.status;     // Catch: Throwable -> L24
            int r103 = this.lastStatus;     // Catch: Throwable -> L24
            if (r102 <= r103) goto L16;
            Iterator r104 = UniteThermal.access$000(this.this$0).iterator();     // Catch: Throwable -> L24
        L14:
            if (r104.hasNext() == false) goto L21;
            ((IThermalMitigation) r104.next()).handleThermalStatusIncrease(r100);     // Catch: Throwable -> L24
        L21:
            monitor-exit(r101);     // Catch: Throwable -> L24
            this.lastStatus = r100.status;
            return;
        L16:
            if (r102 >= r103) goto L21;
            Iterator r105 = UniteThermal.access$000(this.this$0).iterator();     // Catch: Throwable -> L24
        L19:
            if (r105.hasNext() == false) goto L21;
            ((IThermalMitigation) r105.next()).handleThermalStatusDecrease(r100);     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            throw th;
        }
    }

    public IActionManager getActionManager() {
        return this.actionManager;
    }

    public IThermalStatusManager getThermalStatusManager() {
        return this.thermalStatusManager;
    }

    private UniteThermal(Context r100) {
        this.thermalMitigationList = new ArrayList();
        this.context = r100;
        this.thermalStatusManager = new ThermalStatusManager(r100);
        this.actionManager = new ActionManager(r100);
        if (TLog.sDebug == false) goto L5;
        SimpleThermalMitigation r101 = new SimpleThermalMitigation();
        this.thermalMitigationList.add(r101);
    L5:
        UniteThermalStatusListener r102 = new UniteThermalStatusListener(this);
        this.listener = r102;
        this.thermalStatusManager.addThermalStatusDetailListener(r102);
    }

    public static /* synthetic */ List access$000(UniteThermal r100) {
        return r100.thermalMitigationList;
    }

    public static UniteThermal getInstance(Context r100) {
        if (mInstance != null) goto L16;
        if (r100 == null) goto L16;
        monitor-enter(UniteThermal.class);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (mInstance != null) goto L10;
        mInstance = new UniteThermal(r100.getApplicationContext());     // Catch: Throwable -> L12
    L10:
        monitor-exit(UniteThermal.class);     // Catch: Throwable -> L12
    L16:
        return mInstance;
    }

    public void registerThermalMitigation(IThermalMitigation r100) {
        List<IThermalMitigation> r101 = this.thermalMitigationList;
        monitor-enter(r101);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.thermalMitigationList.contains(r100) == true) goto L11;
        this.thermalMitigationList.add(r100);     // Catch: Throwable -> L13
        StringBuilder r102 = new StringBuilder("register mitigation:");     // Catch: Throwable -> L13
        if (r100 != null) goto L9;
        String r103 = "null";
    L10:
        r102.append(r103);     // Catch: Throwable -> L13
        TLog.i(r102.toString());     // Catch: Throwable -> L13
        goto L11
    L9:
        r103 = r100.getDescription();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
    }

    public void unregisterThermalMitigation(IThermalMitigation r100) {
        List<IThermalMitigation> r101 = this.thermalMitigationList;
        monitor-enter(r101);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.thermalMitigationList.contains(r100) == false) goto L11;
        this.thermalMitigationList.remove(r100);     // Catch: Throwable -> L13
        StringBuilder r102 = new StringBuilder("unregister mitigation:");     // Catch: Throwable -> L13
        if (r100 != null) goto L9;
        String r103 = "null";
    L10:
        r102.append(r103);     // Catch: Throwable -> L13
        TLog.i(r102.toString());     // Catch: Throwable -> L13
        goto L11
    L9:
        r103 = r100.getDescription();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
    }
}
