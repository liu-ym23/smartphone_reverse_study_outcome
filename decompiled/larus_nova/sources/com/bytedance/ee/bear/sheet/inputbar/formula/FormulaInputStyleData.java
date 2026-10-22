package com.bytedance.ee.bear.sheet.inputbar.formula;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class FormulaInputStyleData implements NonProguard {
    private List<ColoredRange> coloredRanges;
    private List<FormulaError> errors;

    public static class ColoredRange implements NonProguard {
        private String color;
        private int end;
        private int start;

        public ColoredRange() {
        }

        public String getColor() {
            return this.color;
        }

        public int getEnd() {
            return this.end;
        }

        public int getStart() {
            return this.start;
        }

        public void setColor(String r100) {
            this.color = r100;
        }

        public void setEnd(int r100) {
            this.end = r100;
        }

        public void setStart(int r100) {
            this.start = r100;
        }
    }

    public static class FormulaError implements NonProguard {
        private int end;
        private String message;
        private String severity;
        private int start;

        public FormulaError() {
        }

        public int getEnd() {
            return this.end;
        }

        public String getMessage() {
            return this.message;
        }

        public String getSeverity() {
            return this.severity;
        }

        public int getStart() {
            return this.start;
        }

        public void setEnd(int r100) {
            this.end = r100;
        }

        public void setMessage(String r100) {
            this.message = r100;
        }

        public void setSeverity(String r100) {
            this.severity = r100;
        }

        public void setStart(int r100) {
            this.start = r100;
        }
    }

    public FormulaInputStyleData() {
    }

    public List<ColoredRange> getColoredRanges() {
        return this.coloredRanges;
    }

    public List<FormulaError> getErrors() {
        return this.errors;
    }

    public void setColoredRanges(List<ColoredRange> r100) {
        this.coloredRanges = r100;
    }

    public void setErrors(List<FormulaError> r100) {
        this.errors = r100;
    }
}
