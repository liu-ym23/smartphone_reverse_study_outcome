package com.ss.android.ml.process.bl;

import com.ss.android.ml.process.MultiTaskOneTask;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class AfOPModel {
    public List<String> args;
    public List<String> labels;

    /* JADX INFO: renamed from: op, reason: collision with root package name */
    public String f449132op;
    public List<Float> opts;
    public List<List<String>> targets;
    public List<MultiTaskOneTask> tasks;

    public AfOPModel() {
    }

    public int getSize1D() {
        if ("multi_task".equals(this.f449132op) == false) goto L8;
        List<MultiTaskOneTask> r100 = this.tasks;
        if (r100 != null) goto L7;
        return 1;
    L7:
        return r100.size();
    L8:
        return 1;
    }

    public int getSize2D() {
        if ("predict_multi".equals(this.f449132op) == false) goto L9;
        List<String> r100 = this.labels;
        if (r100 != null) goto L7;
    L24:
        return 1;
    L7:
        return r100.size();
    L9:
        if ("multi_task".equals(this.f449132op) == false) goto L24;
        List<MultiTaskOneTask> r101 = this.tasks;
        if (r101 == null) goto L24;
        Iterator<MultiTaskOneTask> r102 = r101.iterator();
        int r103 = 1;
    L14:
        if (r102.hasNext() == false) goto L23;
        MultiTaskOneTask r104 = r102.next();
        if ("predict_multi".equals(r104.f449131op) == false) goto L20;
        List<String> r105 = r104.labels;
        if (r105 == null) goto L20;
        int r106 = r105.size();
    L21:
        if (r106 <= r103) goto L14;
        r103 = r106;
    L20:
        r106 = 1;
        goto L21
    L23:
        return r103;
    }

    public String toString() {
        return "AfOPModel{labels=" + this.labels + ", op='" + this.f449132op + "', args=" + this.args + ", opts=" + this.opts + ", tasks=" + this.tasks + '}';
    }

    public List<String> getArgs() {
        return this.args;
    }

    public List<String> getLabels() {
        return this.labels;
    }

    public List<Float> getOPTs() {
        return this.opts;
    }

    public String getOperator() {
        return this.f449132op;
    }

    public List<List<String>> getTargets() {
        return this.targets;
    }

    public List<MultiTaskOneTask> getTasks() {
        return this.tasks;
    }
}
