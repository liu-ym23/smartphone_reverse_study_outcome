package com.bytedance.ee.bear.sheet.inputbar.formula;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class FormulaSignatureHelpData implements NonProguard {
    private int activeParam;
    private String functionName;
    private List<Param> params;
    private String requestId;
    private String returnType;

    public static class Param implements NonProguard {
        private String name;
        private boolean optional;
        private String type;

        public Param() {
        }

        public String getName() {
            return this.name;
        }

        public String getType() {
            return this.type;
        }

        public boolean isOptional() {
            return this.optional;
        }

        public void setName(String r100) {
            this.name = r100;
        }

        public void setOptional(boolean r100) {
            this.optional = r100;
        }

        public void setType(String r100) {
            this.type = r100;
        }
    }

    public FormulaSignatureHelpData() {
    }

    public int getActiveParam() {
        return this.activeParam;
    }

    public String getFunctionName() {
        return this.functionName;
    }

    public List<Param> getParams() {
        return this.params;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getReturnType() {
        return this.returnType;
    }

    public void setActiveParam(int r100) {
        this.activeParam = r100;
    }

    public void setFunctionName(String r100) {
        this.functionName = r100;
    }

    public void setParams(List<Param> r100) {
        this.params = r100;
    }

    public void setRequestId(String r100) {
        this.requestId = r100;
    }

    public void setReturnType(String r100) {
        this.returnType = r100;
    }
}
